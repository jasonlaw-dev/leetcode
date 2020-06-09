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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        s = sb.toString();

        int N = s.length();
        char[] str = s.toCharArray();
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }
        for (int len = 1; len < N; len++) {
            for (int j = len; j < N; j++) {
                int i = j - len;
                dp[i][j] = len + 1;
                for (int k = i + 1; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k][j] - (str[k - 1] == str[j] ? 1 : 0));
                }
            }
        }
        return dp[0][N - 1];
    }
}
// @lc code=end

