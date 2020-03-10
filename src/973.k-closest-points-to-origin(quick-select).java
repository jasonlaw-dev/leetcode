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
        int[][] res = new int[K][];
        if (K == 0) {
            return res;
        }
        int part = quickSelect(points, 0, points.length - 1, K);
        for (int i = 0; i <= part; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private int quickSelect(int[][] points, int start, int end, int k) {
        swap(points, end, start + (int)((end - start + 1) * Math.random()));
        int pivot = points[end][0] * points[end][0] + points[end][1] * points[end][1];
        int i = start;
        for (int j = start; j <= end; j++) {
            if (points[j][0] * points[j][0] + points[j][1] * points[j][1] < pivot) {
                swap(points, i++, j);
            }
        }
        swap(points, i, end);
        int count = i - start + 1;
        if (count < k) {
            return quickSelect(points, i + 1, end, k - count);
        } else if (count > k) {
            return quickSelect(points, start, i - 1, k);
        }
        return i;
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
// @lc code=end

