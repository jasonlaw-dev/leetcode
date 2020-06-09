/*
 * @lc app=leetcode id=664 lang=java
 *
 * [664] Strange Printer
 * AAAAACCACABB
 */

// @lc code=start
class Solution {
    public int strangePrinter(String s) {
        if (s.length() == 0) return 0;
        int[][] memo = new int[s.length()][s.length()];
        return dfs(s.toCharArray(), 0, s.length() - 1, memo);
    }
    int dfs(char[] s, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        memo[i][j] = 1 + dfs(s, i, j - 1, memo);
        for (int k = i; k < j; k++) {
            if (s[k] == s[j]) {
                memo[i][j] = Math.min(memo[i][j], dfs(s, i, k, memo) + dfs(s, k + 1, j - 1, memo));
            }
        }
        return memo[i][j];
    }

}
// @lc code=end

