/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }
        int i = 0;
        int j = matrix.length - 1;
        while (i < j) {
            int mid = (int) Math.ceil((i + j) / 2.0);
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] > target) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        int row = i;
        if (matrix[row][matrix[0].length - 1] < target) {
            return false;
        }

        i = 0;
        j = matrix[0].length;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
}
// @lc code=end

