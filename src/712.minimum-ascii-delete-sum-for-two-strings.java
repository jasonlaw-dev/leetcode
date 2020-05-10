/*
 * @lc app=leetcode id=712 lang=java
 *
 * [712] Minimum ASCII Delete Sum for Two Strings
 */

// dp[i + 1][j + 1]: represents minimum sum to make s1[0, i] == s2[0, j]
// compare whether s1[i] == s2[j], if yes, then current minimum would be dp[i][j]


// @lc code=start
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            dp[i + 1][0] = dp[i][0] + s1.charAt(i);
        }
        for (int j = 0; j < s2.length(); j++) {
            dp[0][j + 1] = dp[0][j] + s2.charAt(j);
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                int a = s1.charAt(i);
                int b = s2.charAt(j);
                if (a != b) {
                    dp[i + 1][j + 1] = Math.min(a + dp[i][j + 1], b + dp[i + 1][j]);
                } else {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
// @lc code=end

