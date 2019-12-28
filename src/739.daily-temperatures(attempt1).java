import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
            return T[a] - T[b];
        });
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!minHeap.isEmpty() && T[minHeap.peek()] < T[i]) {
                int j = minHeap.poll();
                res[j] = i - j;
            }
            minHeap.add(i);
        }
        return res;
    }
}
// @lc code=end

