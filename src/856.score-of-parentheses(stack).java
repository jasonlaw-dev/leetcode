import java.util.Stack;

/*
 * @lc app=leetcode id=856 lang=java
 *
 * [856] Score of Parentheses
 */

// @lc code=start
class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(0);
            } else {
                int prev = stack.pop();
                if (S.charAt(i - 1) == '(') {
                    stack.push(stack.pop() + 1);
                } else {
                    stack.push(stack.pop() + 2 * prev);
                }
            }
        }
        return stack.pop();
    }
}
// @lc code=end

