/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += charToInt(s.charAt(i)) * Math.pow(26, s.length() - i - 1);
        }
        return sum;
    }
    public int charToInt(char c) {
        return (int)(c - 'A' + 1);
    }
}
// @lc code=end

