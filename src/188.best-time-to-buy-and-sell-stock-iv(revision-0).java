import java.util.Arrays;

/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length /  2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int[] hold = new int[k + 1];
        int[] release = new int[k + 1];
        Arrays.fill(hold, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                release[j] = Math.max(release[j], hold[j] + price);
                hold[j] = Math.max(hold[j], release[j - 1] - price);
            }
        }
        return release[k];
    }
}
// @lc code=end

