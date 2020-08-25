/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return 0;
        }
        // @@@@ 2D DP
        // int[][] dp = new int[m + 1][n + 1];
        // for (int i = 0; i < m; i++) {
        //     dp[i][0] = 1;
        //     for (int j = 0; j < n; j++) {
        //         dp[i+1][j+1] = dp[i][j+1];
        //         if (s.charAt(i) == t.charAt(j)) {
        //             dp[i+1][j+1] += dp[i][j];
        //         }
        //     }
        // }
        // return dp[m][n];
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            int prev = 1;
            for (int j = 0; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j] += prev;
                }
                prev = temp;
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end

