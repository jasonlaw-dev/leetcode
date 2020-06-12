import java.util.Arrays;

/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins.length == 0) return 0;
        // Arrays.sort(coins);
        
        int[][] memo = new int[amount + 1][coins.length];
        
        return bt(amount, coins, coins.length - 1, memo);
    }
    private int bt(int amount, int[] coins, int lastIndex, int[][] memo) {
        if (amount == 0) return 1;
        if (lastIndex < 0) return 0;
        // if (lastIndex == 0) return amount % coins[0] == 0 ? 1 : 0;
        if (memo[amount][lastIndex] == 0) {
            memo[amount][lastIndex] = bt(amount, coins, lastIndex - 1, memo);
            if (amount >= coins[lastIndex]) {
                memo[amount][lastIndex] += bt(amount - coins[lastIndex], coins, lastIndex, memo);
            }
            if (memo[amount][lastIndex] == 0) {
                memo[amount][lastIndex] = -1;
            }
        }
        return memo[amount][lastIndex] != -1 ? memo[amount][lastIndex] : 0;
    }
}
// @lc code=end

