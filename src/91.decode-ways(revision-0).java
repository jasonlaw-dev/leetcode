/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int prev2 = 1;
        int prev1 = 1;
        if (s.startsWith("0")) {
            return 0;
        }
        for (int i = 1; i < len; i++) {
            if (i > 0 && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                int temp = (s.charAt(i) == '0' ? 0 : prev1) + prev2;
                prev2 = prev1;
                prev1 = temp;
            } else if (s.charAt(i) == '0') {
                return 0;
            } else {
                prev2 = prev1;
            }
        }
        return prev1;
    }
}
// @lc code=end

