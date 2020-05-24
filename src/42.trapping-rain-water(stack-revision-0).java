import java.util.Stack;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int j = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int k = stack.peek();
                sum += (Math.min(height[k], height[i]) - height[j]) * (i - k - 1);
            }
            stack.push(i);
        }
        return sum;
    }
}
// @lc code=end

