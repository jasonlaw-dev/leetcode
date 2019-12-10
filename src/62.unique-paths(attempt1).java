/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 * Time: O(m*n)
 * Space: O(m*n)
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][];
        for (int i = 0; i < m; i++) {
            dp[i] = new int[n];
        }
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            for (int col = j; col >= 0; col--) {
                if (i == m - 1 && col == n - 1) {
                    dp[i][col] = 1;
                } else {
                    dp[i][col] = (i + 1 < m ? dp[i + 1][col] : 0) + (col + 1 < n ? dp[i][col + 1] : 0);
                }
            }
            for (int row = i - 1; row >= 0; row--) {
                dp[row][j] = (row + 1 < m ? dp[row + 1][j] : 0) + (j + 1 < n ? dp[row][j + 1] : 0);
            }
            i--;
            j--;
        }
        return dp[0][0];
    }
}
// @lc code=end

