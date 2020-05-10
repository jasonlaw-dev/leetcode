import java.util.Stack;

/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        // false -> left child not visited
        // true -> left child visited
        Stack<Boolean> stack = new Stack<>();
        stack.push(true);
        int n = preorder.length();
        for (int i = 0; i <= n; i++) {
            char c = i != n ? preorder.charAt(i) : ',';
            if (c == ',') {
                if (preorder.charAt(i - 1) == '#') {
                    while (!stack.isEmpty() && stack.peek()) {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                        stack.push(true);
                    } else if (i != n) {
                        return false;
                    }
                } else {
                    stack.push(false);
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

