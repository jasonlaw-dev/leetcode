import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int[] x = A[i];
            int[] y = B[j];

            int[] pair = { Math.max(x[0], y[0]), Math.min(x[1], y[1]) };
            if (pair[0] <= pair[1]) {
                res.add(pair);
            }
            if (x[1] < y[1]) {
                i++;
            } else if (x[1] > y[1]) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end

