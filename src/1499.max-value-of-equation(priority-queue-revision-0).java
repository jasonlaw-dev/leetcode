import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1499 lang=java
 *
 * [1499] Max Value of Equation
 */

// @lc code=start
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int res = Integer.MIN_VALUE;
        for (int[] point : points) {
            while (!pq.isEmpty() && point[0] - pq.peek()[1] > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                res = Math.max(res, pq.peek()[0] + point[0] + point[1]);
            }
            pq.offer(new int[] {point[1] - point[0], point[0]});
        }
        return res;
    }
}
// @lc code=end

