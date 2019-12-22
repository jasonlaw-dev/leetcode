/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !isAlphanumeric(s.charAt(i))) {
                i++;
            }
            while (i < j && !isAlphanumeric(s.charAt(j))) {
                j--;
            }
            if (i < j && !isEqual(s.charAt(i), s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    public char toLower(char c) {
        if (c >= 'A' && c <= 'Z' ) {
            return (char) (c - 'A' + 'a');
        }
        return c;
    }
    public boolean isEqual(char a, char b) {
        return toLower(a) == toLower(b);
    }
    public boolean isAlphanumeric(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c<='9';
    }
}
// @lc code=end

