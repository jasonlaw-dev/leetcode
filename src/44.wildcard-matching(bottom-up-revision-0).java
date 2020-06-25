/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] matched = new boolean[s.length() + 1][p.length() + 1];
        matched[s.length()][p.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                matched[s.length()][i] = true;
            } else {
                break;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    matched[i][j] = matched[i+1][j+1];
                } else if (p.charAt(j) == '*') {
                    matched[i][j] = matched[i+1][j] || matched[i][j+1];
                }
            }
        }
        return matched[0][0];
    }
}
// @lc code=end

