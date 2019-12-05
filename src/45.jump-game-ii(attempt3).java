/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int currEnd = 0;
        int currFarthest = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == currEnd) {
                steps++;
                currEnd = currFarthest;
            }
        }
        return steps;
    }
}
// @lc code=end

