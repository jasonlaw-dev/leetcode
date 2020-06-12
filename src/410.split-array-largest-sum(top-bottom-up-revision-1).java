/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + nums[i];
            dp[i] = sums[i+1];
        }
        for (int k = 1; k < m; k++) {
            for (int j = n - 1; j >= k; j--) {
                dp[j] = Integer.MAX_VALUE;
                for (int i = j; i >= k; i--) {
                    int rightSum = sums[j + 1] - sums[i];
                    dp[j] = Math.min(dp[j], Math.max(dp[i - 1], rightSum));
                    if (rightSum > dp[i-1]) {
                        break;
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end

