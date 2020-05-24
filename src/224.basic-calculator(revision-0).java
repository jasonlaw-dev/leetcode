import java.util.Stack;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start

class Solution {
    public int calculate(String s) {
        int currVal = 0;
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                currVal = currVal * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result += currVal * sign;
                sign = c == '+' ? 1 : -1;
                currVal = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += currVal * sign;
                result *= stack.pop();
                result += stack.pop();
                currVal = 0;
            }
        }
        return result + (sign * currVal);
    }
}
// @lc code=end

