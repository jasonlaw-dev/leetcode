/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (sum < Math.abs(S)) {
            return 0;
        }
        int arraySize = 2*sum+1;
        int[] dp = new int[arraySize];
        dp[0 + sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                if (dp[j] > 0) {
                    next[j + nums[i]] += dp[j];
                    next[j - nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[S + sum];
    }
}
// @lc code=end

