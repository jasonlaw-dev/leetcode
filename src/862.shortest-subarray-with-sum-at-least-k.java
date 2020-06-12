import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=862 lang=java
 *
 * [862] Shortest Subarray with Sum at Least K
 */

// @lc code=start
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int[] sum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sum[i+1] = A[i] + sum[i];
        }
        int min = A.length + 1;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < A.length + 1; i++) {
            while (!queue.isEmpty() && sum[i] <= sum[queue.peekLast()]) {
                queue.pollLast();
            }
            while (!queue.isEmpty() && sum[i] - sum[queue.peekFirst()] >= K) {
                min = Math.min(min, i - queue.pollFirst());
            }
            queue.offerLast(i);
        }
        return min == A.length + 1 ? -1 : min;
    }
}
// @lc code=end

