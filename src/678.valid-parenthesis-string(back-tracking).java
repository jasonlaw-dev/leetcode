/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

// 1000 *

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        return bt(s, 0, new Boolean[s.length()][s.length()], 0);
    }

    public boolean bt(String s, int i, Boolean[][] memo, int open) {
        if (open < 0 || open > s.length() - i) {
            return false;
        }
        if (i == s.length()) {
            return open == 0;
        }
        if (memo[i][open] != null) {
            return memo[i][open];
        }
        char c = s.charAt(i);
        boolean res;
        if (c == '(') {
            res = bt(s, i + 1, memo, open + 1);
        } else if (c == ')') {
            res = bt(s, i + 1, memo, open - 1);
        } else {
            res = bt(s, i + 1, memo, open) || bt(s, i + 1, memo, open + 1) || bt(s, i + 1, memo, open - 1);
        }
        memo[i][open] = res;
        return res;
    }
}
// @lc code=end

