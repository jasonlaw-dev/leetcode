/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length > 1) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                } else {
                    maxProfit = Math.max(prices[i] - min, maxProfit);
                }
            }
        } 
        return maxProfit;
    }
}
// @lc code=end

