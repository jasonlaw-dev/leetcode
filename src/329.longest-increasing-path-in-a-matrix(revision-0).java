/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    int[] directions = {1,-1};
    int rows = 0;
    int cols = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        rows = matrix.length;
        cols = matrix[0].length;
        int max = 0;
        Integer[][] dp = new Integer[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, lip(matrix, i, j, dp));
            }
        }
        return max;
    }
    public int lip(int[][] matrix, int i, int j, Integer[][] dp) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int res = 1;
        for (int m = 0; m < 4; m++) {
            int nextI = i + (m < 2 ? directions[m] : 0);
            int nextJ = j + (m >= 2 ? directions[m % 2] : 0);
            if (nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols && matrix[nextI][nextJ] > matrix[i][j]) {
                res = Math.max(res, 1 + lip(matrix, nextI, nextJ, dp));
            }
        }
        dp[i][j] = res;
        return res;
    }
}
// @lc code=end

