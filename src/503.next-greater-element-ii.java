import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res, -1);
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    int idx = stack.pop();
                    if (res[idx] == -1) {
                        res[idx] = nums[i];
                    }
                }
                stack.push(i);
            }
        }
        return res;        
    }
}
// @lc code=end

