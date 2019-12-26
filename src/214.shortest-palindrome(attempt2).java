/*
 * @lc app=leetcode id=214 lang=java
 *
 * [214] Shortest Palindrome
 */

// @lc code=start
class Solution {
    public String shortestPalindrome(String s) {
        int i = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if (i == s.length()) {
            return s;
        }
        String suffix = s.substring(i);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, i)) + suffix;
    }
}
// @lc code=end

