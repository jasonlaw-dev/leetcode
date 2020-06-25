/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 * 
 * i == s.length() && j == p.length()
 * what if j == p.length() return false
 * 
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0, new boolean[s.length() + 1][p.length() + 1]);
    }
    private boolean isMatch(String s, String p, int i, int j, boolean[][] visited) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (i > s.length()) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (p.charAt(j) == '*') {
            return isMatch(s, p, i + 1, j, visited) || isMatch(s, p, i, j + 1, visited);
        }
        if (i != s.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
            return isMatch(s, p, i + 1, j + 1, visited);
        }
        return false;
    }
}
// @lc code=end

