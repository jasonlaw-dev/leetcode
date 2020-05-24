/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1 || j < n - 1) {
                    int next = Math.min(i < m - 1 ? dp[i+1][j] : Integer.MAX_VALUE, j < n - 1 ? dp[i][j+1] : Integer.MAX_VALUE);
                    dp[i][j] = next - dungeon[i][j];
                } else {
                    dp[i][j] = 1 - dungeon[i][j];
                }
                if (dp[i][j] <= 0) {
                    dp[i][j] = 1;
                }
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

