/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] s0 = new int[prices.length]; // have nothing
        int[] s1 = new int[prices.length]; // hold 1 stock
        int[] s2 = new int[prices.length]; // just sold
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s1[i-1], s0[i-1] - prices[i]);
            s2[i] = s1[i-1] + prices[i];
        }
        return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
    }
}
// @lc code=end

