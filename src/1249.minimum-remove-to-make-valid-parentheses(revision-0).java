/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
                sb.append(c);
            } else if (c == ')') {
                if (open > 0) {
                    sb.append(c);
                    open--;
                }
            } else {
                sb.append(c);
            }
        }
        s = sb.toString();
        open = 0;
        sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                open++;
                sb.append(c);
            } else if (c == '(') {
                if (open > 0) {
                    sb.append(c);
                    open--;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

