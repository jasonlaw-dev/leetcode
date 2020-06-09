import java.util.Stack;

/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int[] left = new int[cols];
        int[] right = new int[cols];
        for (int j = 0; j < cols; j++) {
            right[j] = cols - 1;
        }

        int max = 0;
        
        for (int i = 0; i < rows; i++) {
            int leftBound = 0;
            for (int j = 0; j < cols; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(leftBound, left[j]);
                } else {
                    left[j] = 0;
                    leftBound = j + 1;
                }
            }
            int rightBound = cols - 1;
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(rightBound, right[j]);
                } else {
                    right[j] = cols - 1;
                    rightBound = j - 1;
                }
                max = Math.max(max, heights[j] * (right[j] - left[j] + 1));
            }
            
        }
        return max;
    }
}
// @lc code=end

