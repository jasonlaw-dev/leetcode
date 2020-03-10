import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points.length <= K) {
            return points;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->  b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }
        int[][] res = new int[K][];
        for (int i = 0; i < K; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
// @lc code=end

