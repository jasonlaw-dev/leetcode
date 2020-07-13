import java.util.Stack;

/*
 * @lc app=leetcode id=1106 lang=java
 *
 * [1106] Parsing A Boolean Expression
 */

// @lc code=start
class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> ops = new Stack<>();
        Stack<Boolean> values = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '&') {
                ops.add(c);
                values.add(true);
            } else if (c == '|') {
                ops.add(c);
                values.add(false);
            } else if (c == '!') {
                ops.add(c);
            } else if (c == 't' || c == 'f') {
                values.add(c == 't');
            } else if (c == ')' || c == ',') {
                char prevOp = ops.peek();
                if (prevOp == '&') {
                    boolean val1 = values.pop();
                    boolean val2 = values.pop();
                    values.add(val1 && val2);
                } else if (prevOp == '|') {
                    boolean val1 = values.pop();
                    boolean val2 = values.pop();
                    values.add(val1 || val2);
                } else {
                    values.add(!values.pop());
                }
                if (c == ')') {
                    ops.pop();
                }
            }
        }
        // System.out.println(values.size() + " " + ops.size());
        return values.peek();
    }
}
// @lc code=end

