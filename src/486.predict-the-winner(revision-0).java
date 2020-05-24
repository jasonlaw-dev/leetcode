/*
 * @lc app=leetcode id=486 lang=java
 *
 * [486] Predict the Winner
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        for (int l = 2; l <= nums.length; l++) {
            for (int i = 0; i < nums.length - l + 1; i++) {
                int k = i + l - 1;
                dp[i] = Math.max(
                    nums[i] - dp[i + 1],
                    nums[k] - dp[i]
                );
            }
        }
        return dp[0] >= 0;
    }
}
// @lc code=end

