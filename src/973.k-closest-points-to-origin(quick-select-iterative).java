import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int start = 0;
        int end = points.length - 1;
        while (start <= end) {
            int part = partition(points, start, end);
            if (part == K) break;
            if (part < K) {
                start = part + 1;
            } else {
                end = part - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] points, int start, int end) {
        swap(points, end, start + (int)((end - start + 1) * Math.random()));
        int pivot = points[end][0] * points[end][0] + points[end][1] * points[end][1];
        int i = start;
        for (int j = start; j <= end; j++) {
            if (points[j][0] * points[j][0] + points[j][1] * points[j][1] < pivot) {
                swap(points, i++, j);
            }
        }
        swap(points, i, end);
        return i;
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
// @lc code=end

