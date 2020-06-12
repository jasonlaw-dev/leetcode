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
        Arrays.sort(coins);
        
        int[][] dp = new int[amount + 1][coins.length];
        for (int j = 0; j < coins.length; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                dp[i][j] = (j > 0 ? dp[i][j - 1] : 0) + (coins[j] <= i ? dp[i - coins[j]][j] : 0);
            }
        }
        return dp[amount][coins.length - 1];
    }
}
// @lc code=end

