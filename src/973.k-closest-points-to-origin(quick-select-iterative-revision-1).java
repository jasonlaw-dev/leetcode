import java.util.Arrays;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
    public int[][] kClosest(int[][] points, int K) {
        int start = 0;
        int end = points.length - 1;
        int n = K;
        while (start < end) {
            swap(points, (int)(start + (end - start + 1) * Math.random()), end);
            int pivotValue = points[end][0] * points[end][0] + points[end][1] * points[end][1];
            int i = start;
            for (int j = start; j < end; j++) {
                if (points[j][0] * points[j][0] + points[j][1] * points[j][1] < pivotValue) {
                    swap(points, i++, j);
                }
            }
            swap(points, i, end);
            if (i + 1 == K) {
                break;
            } else if (i < K) {
                start = i + 1;
            } else {
                end = i - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, n);
    }
}
// @lc code=end

