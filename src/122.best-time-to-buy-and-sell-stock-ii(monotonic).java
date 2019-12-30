import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// this is not efficient at all, I am just trying to do monotonic queue

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i <= prices.length; i++) {
            int price = i == prices.length ? 0 : prices[i];
            if (!q.isEmpty() && prices[q.peekLast()] >= price) {
                int last = q.pollLast();
                profit += q.isEmpty() ? 0 : prices[last] - prices[q.peekFirst()];
                q = new ArrayDeque<>();
            }
            q.add(i);
        }
        return profit;
    }
}
// @lc code=end

