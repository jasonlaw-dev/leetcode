/*
 * @lc app=leetcode id=546 lang=java
 *
 * [546] Remove Boxes
 * 
 * Thinking process:
 * T(i, j) to represent number of points that we can get from boxes[i, j]
 * say if we remove boxes[i] first, then T(i, j) = 1 + T(i + 1, j),
 * the problem is that, it may not be optimal, 
 * because there could be boxes of same color as boxes[i] to the left that can be popped tgt
 * 
 * Say if we define k as the number of boxdes of the same color as boxes[i]
 * T(i, j, k) = (k + 1) ^ 2 + T(i + 1, j, 0)  remove boxes[i] first
 * OR
 * = T(i+1, m - 1, 0) + T(m, j, k+1) where i < m <= j && boxes[i] == boxes[m]
 */

// @lc code=start
class Solution {

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        return removeBoxes(boxes, 0, n - 1, 0, new int[n][n][n]);
    }
    public int removeBoxes(int[] boxes, int i, int j, int k, int[][][] memo) {
        if (i > j) return 0;
        if (memo[i][j][k] > 0) return memo[i][j][k];
        while (i + 1 <= j && boxes[i] == boxes[i + 1]) {
            i++;
            k++;
        }
        memo[i][j][k] = (k + 1) * (k + 1) + removeBoxes(boxes, i + 1, j, 0, memo);
        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                memo[i][j][k] = Math.max(memo[i][j][k], removeBoxes(boxes, i + 1, m - 1, 0, memo) + removeBoxes(boxes, m, j, k + 1, memo));
            }
        }
        return memo[i][j][k];
    }
}
// @lc code=end

