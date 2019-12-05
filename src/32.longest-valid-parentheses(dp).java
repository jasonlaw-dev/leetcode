import java.util.Stack;

/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */


 // To check whether a substring is valid
// @lc code=start


// (())
// 0 0 2 0
class Solution {

    public int longestValidParentheses(String s) {
        int max = 0;

        int[] dp = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i > 0) {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}
// @lc code=end

