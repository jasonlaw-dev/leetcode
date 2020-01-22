/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        int[] dp = new int[nums.length];

        // dp[i, j] -> results for (i + 1) parts and A[j] to A[len - 1]
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            dp[i] = sums[nums.length] - sums[i];
        }
        for (int cuts = 1; cuts < m; cuts++) {
            for (int i = 0; i < nums.length - cuts; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = i + 1; j < nums.length - cuts + 1; j++) {
                    int leftSum = sums[j] - sums[i];
                    dp[i] = Math.min(dp[i], Math.max(dp[j], leftSum));
                    if (leftSum > dp[j]) {
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}
// @lc code=end

