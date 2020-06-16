/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][2];
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][1] = Integer.MIN_VALUE;
        for (int price : prices) {
            dp[1][0] = Math.max(dp[1][0], dp[1][1] + price);
            dp[1][1] = Math.max(dp[1][1], dp[0][0] - price);
            dp[0][0] = Math.max(dp[0][0], dp[0][1] + price);
            dp[0][1] = Math.max(dp[0][1], - price);
        }
        return Math.max(dp[1][0], dp[0][0]);
    }
}
// @lc code=end

