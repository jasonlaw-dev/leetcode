/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */

// @lc code=start
class Solution {
    public int minAddToMakeValid(String S) {
        int open = 0;
        int res = 0;
        int n = S.length();
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    res++;
                }
            }
        }
        return res + open;
    }
}
// @lc code=end

