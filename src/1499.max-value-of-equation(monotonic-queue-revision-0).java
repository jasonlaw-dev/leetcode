import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=1499 lang=java
 *
 * [1499] Max Value of Equation
 */

// @lc code=start
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            while (!deque.isEmpty() && point[0] - points[deque.peekFirst()][0] > k) {
                deque.pollFirst();
            }
            if (!deque.isEmpty()) {
                int[] prevPoint = points[deque.peekFirst()];
                res = Math.max(res, prevPoint[1] - prevPoint[0] + point[0] + point[1]);
            }
            while (!deque.isEmpty()) {
                int[] prevPoint = points[deque.peekLast()];
                if (prevPoint[1] - prevPoint[0] <= point[1]-point[0]) {
                    deque.pollLast();
                } else {
                    break;
                }
            }
            deque.offer(i);
        }
        return res;
    }
}
// @lc code=end

