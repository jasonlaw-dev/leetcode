/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

 // 0 -> buy, 1 -> sell, 2->cooldown
// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][3];
        dp[0][0] = Integer.MIN_VALUE;
        for (int price : prices) {
            dp[1][0] = Math.max(dp[0][0], dp[0][2] - price);
            dp[1][1] = Math.max(dp[0][1], dp[0][0] + price);
            dp[1][2] = Math.max(dp[0][2], dp[0][1]);
            int[] temp = dp[0];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return Math.max(dp[0][1], dp[0][2]);
    }
}
// @lc code=end

