import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=918 lang=java
 *
 * [918] Maximum Sum Circular Subarray
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int[] sums = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sums[i + 1] = sums[i] + A[i];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> sums[a] - sums[b]);
        heap.offer(0);
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, sums[i + 1] - sums[heap.peek()]);
            heap.offer(i + 1);
        }
        for (int i = 0; i < A.length; i++) {
            while (!heap.isEmpty() && heap.peek() - 1 <= i) heap.poll();
            if (heap.isEmpty()) break;

            int sum = sums[i + 1] + sums[sums.length - 1] - sums[heap.peek()];
            max = Math.max(max, sum);
        }
        return max;
    }
}
// @lc code=end

