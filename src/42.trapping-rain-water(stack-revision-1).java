/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int bottom = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                res += (Math.min(height[i], height[stack.peek()]) - bottom) * (i - stack.peek() - 1);
            }
            stack.add(i);
        }
        return res;
    }
}
// @lc code=end

