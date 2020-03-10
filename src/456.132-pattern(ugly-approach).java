import java.util.Stack;

/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{nums[0], nums[0]});
        for (int num : nums) {
            int[] top = stack.peek();
            if (num < top[0]) {
                stack.push(new int[] {num, num});
            } else if (num >= top[1]) {
                top[1] = num;
            } else if (num > top[0]) {
                return true;
            }
        }
        int[] prev = stack.pop();
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            if (prev[1] < curr[1]) {
                if (prev[1] > curr[0]) {
                    return true;
                }
                prev = curr;
            }
        }
        return false;
    }
}
// @lc code=end

