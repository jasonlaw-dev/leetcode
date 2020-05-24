/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[][] dp = new int[2][3];
        // 0 0 refers to 1st considered, 3 houses before
        // 0 0 refers to 1st not considered, 3 houses before
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = Math.max(dp[0][0], dp[0][1]) + nums[i];
            dp[0][0] = dp[0][1];
            dp[0][1] = dp[0][2];
            dp[0][2] = sum;
        }
        for (int i = 1; i < nums.length; i++) {
            int sum = Math.max(dp[1][0], dp[1][1]) + nums[i];
            dp[1][0] = dp[1][1];
            dp[1][1] = dp[1][2];
            dp[1][2] = sum;
        }
        return Math.max(Math.max(dp[0][1], dp[0][2]), Math.max(dp[1][1], dp[1][2]));
    }
}
// @lc code=end

