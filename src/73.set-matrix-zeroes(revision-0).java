/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] colZeros = new boolean[cols];
        for (int i = 0; i < rows; i++) {
            boolean clearRow = false;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    colZeros[j] = true;
                    clearRow = true;
                }
            }
            if (clearRow) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < cols; j++) {
            if (colZeros[j]) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
// @lc code=end

