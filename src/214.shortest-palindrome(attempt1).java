/*
 * @lc app=leetcode id=214 lang=java
 *
 * [214] Shortest Palindrome
 */

// @lc code=start
class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int lastPalEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >=0; j--) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    if (j == 0) {
                        lastPalEnd = i;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i > lastPalEnd; i--) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i <= lastPalEnd; i++) {
            sb.append(s.charAt(i));
        }
        for (int i = lastPalEnd + 1; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
// @lc code=end

