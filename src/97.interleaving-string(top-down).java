/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return isInterleave(s1, s2, s3, s1.length(), s2.length(), memo);
    }
    public boolean isInterleave(String s1, String s2, String s3, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        memo[i][j] = i == 0 && j == 0
         || i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && isInterleave(s1, s2, s3, i - 1, j, memo)
         || j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1) && isInterleave(s1, s2, s3, i, j - 1, memo);
        return memo[i][j];
    }
}
// @lc code=end

