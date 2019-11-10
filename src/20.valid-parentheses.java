import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 * 
 *  Time: O(n)
 *  Space: O(n)
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char prev = stack.pop();
                if (prev == '(' && c != ')' || prev == '{' && c != '}' || prev == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

