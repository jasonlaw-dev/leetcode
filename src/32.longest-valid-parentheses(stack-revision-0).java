import java.util.Stack;

/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */


 // To check whether a substring is valid
// @lc code=start
class Solution {

    // scan through array
    // open parenthesis -> add index to stack
    // close parenthesis -> pop the stack if the top of the stack is open


    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i- stack.peek());
                }
            }
        }
        return max;
    }
}
// @lc code=end

