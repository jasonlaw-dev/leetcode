/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int prevBuy = -prices[0];
        int prevSell = 0;
        for (int i = 1; i < prices.length; i++) {
            int buy = Math.max(prevBuy, prevSell - prices[i]);
            int sell = Math.max(prevSell, prevBuy + prices[i] - fee);
            prevBuy = buy;
            prevSell = sell;
        }
        return prevSell;
    }
}
// @lc code=end

