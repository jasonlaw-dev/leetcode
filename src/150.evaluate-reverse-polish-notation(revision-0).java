import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {

    public int evalRPN(String[] tokens) {
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int operator = operators.indexOf(token);
            if (operator == -1) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());
                int res;
                if (operator == 0) {
                    res = a + b;
                } else if (operator == 1) {
                    res = a - b;
                } else if (operator == 2) {
                    res = a * b;
                } else {
                    res = a / b;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
// @lc code=end

