/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            boolean match = false;
            for (int coin : coins) {
                if (i >= coin && dp[i-coin] >= 0) {
                    match = true;
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
            if (!match) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }
}
// @lc code=end
