/*
 * @lc app=leetcode id=1092 lang=java
 *
 * [1092] Shortest Common Supersequence 
 */

// @lc code=start
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][][] dp = new int[m + 1][n + 1][3];
        dp[0][0][1] = -1;
        dp[0][0][2] = -1;
        for (int i = 0; i < m; i++) {
            dp[i + 1][0][0] = 1 + dp[i][0][0];
            dp[i + 1][0][1] = i;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j + 1][0] = 1 + dp[0][j][0];
            dp[0][j + 1][2] = j;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1][0] = 1 + dp[i][j][0];
                    dp[i + 1][j + 1][1] = i;
                    dp[i + 1][j + 1][2] = j;
                } else {
                    if (dp[i][j + 1][0] < dp[i + 1][j][0]) {
                        dp[i + 1][j + 1][0] = 1 + dp[i][j + 1][0];
                        dp[i + 1][j + 1][1] = i;
                        dp[i + 1][j + 1][2] = j + 1;
                    } else {
                        dp[i + 1][j + 1][0] = 1 + dp[i + 1][j][0];
                        dp[i + 1][j + 1][1] = i + 1;
                        dp[i + 1][j + 1][2] = j;
                    }
                }
            }
        }
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while (i != 0 || j != 0) {
            if (dp[i][j][1] == i - 1 && dp[i][j][2] == j - 1) {
                sb.append(str1.charAt(i - 1));
            } else if (dp[i][j][1] == i - 1) {
                sb.append(str1.charAt(i - 1));
            } else {
                sb.append(str2.charAt(j - 1));
            }
            int x = dp[i][j][1];
            int y = dp[i][j][2];
            i = x;
            j = y;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

