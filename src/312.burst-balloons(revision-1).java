/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];
        for (int len = 0; len < nums.length; len++) { 
            for (int i = 0; i < nums.length - len; i++) {
                int j = i + len;
                int leftBound = i == 0 ? 1 : nums[i - 1];
                int rightBound = j == nums.length - 1 ? 1 : nums[j + 1];
                for (int k = i; k <= j; k++) {
                    int leftSum = k != i ? dp[i][k - 1] : 0;
                    int rightSum = k != j ? dp[k + 1][j] : 0;
                    dp[i][j] = Math.max(dp[i][j], leftSum + rightSum + leftBound * rightBound * nums[k]);
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}
// @lc code=end

