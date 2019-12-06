/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    // " a "
    // 0 1 2
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int end = s.length();
        while (i >= 0 && s.charAt(i) == ' ') {
            end = i--;
        }
        int start = end;
        while (i >= 0 && s.charAt(i) != ' ') {
            start = i--;
        }
        return end - start;
    }
}
// @lc code=end

