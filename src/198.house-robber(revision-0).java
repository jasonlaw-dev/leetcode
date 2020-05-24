/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int[] previous = new int[3];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i] + Math.max(previous[0], previous[1]);
            previous[0] = previous[1];
            previous[1] = previous[2];
            previous[2] = sum;
        }
        return Math.max(previous[1], previous[2]);
    }
}
// @lc code=end

