/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        for (int i = nums.length - 2; i>= 0; i--) {
            int furthest = Math.min(nums.length - 1, i + nums[i]);
            if (furthest == nums.length - 1) {
                memo[i] = 1;
            } else {
                for (int j = i + 1; j <= furthest; j++) {
                    if (memo[j] > 0) {
                        memo[i] = memo[i] == 0 ? memo[j] + 1 : Math.min(memo[j] + 1, memo[i]);
                    }
                }
            }
            
        }
        return memo[0];
    }
}
// @lc code=end

