import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return results;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowStart = 0;
        int colStart = 0;
        while (results.size() < rows * cols) {
            for (int col = colStart; col < cols - colStart; col++) {
                results.add(matrix[rowStart][col]);
            }
            for (int row = rowStart + 1; row < rows - rowStart - 1; row++) {
                results.add(matrix[row][cols - colStart - 1]);
            }
            if (rows - rowStart - 1 != rowStart) {
                for (int col = cols - colStart - 1; col >= colStart; col--) {
                    results.add(matrix[rows - rowStart - 1][col]);
                }
            }
            if (colStart != cols - colStart - 1) {
                for (int row = rows - rowStart - 2; row >= rowStart + 1; row--) {
                    results.add(matrix[row][colStart]);
                }
            }
            rowStart++;
            colStart++;
        }
        return results;
    }
}
// @lc code=end

