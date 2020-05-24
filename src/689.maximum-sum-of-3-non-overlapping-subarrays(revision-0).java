/*
 * @lc app=leetcode id=689 lang=java
 *
 * [689] Maximum Sum of 3 Non-Overlapping Subarrays
 */

// brute force n^3

// @lc code=start
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sums = new int[nums.length - (k - 1)];
        for (int i = 0; i < k; i++) {
            sums[0] += nums[i];
        }
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        int[][][] dp = new int[sums.length][3][2];
        for (int j = 0; j < 3; j++) {
            for (int i = j * k; i < sums.length; i++) {
                dp[i][j][0] = i;
                dp[i][j][1] = sums[i] + (j == 0 ? 0 : dp[i - k][j - 1][1]);
                if (i > j * k && dp[i][j][1] <= dp[i - 1][j][1]) {
                    dp[i][j][0] = dp[i - 1][j][0];
                    dp[i][j][1] = dp[i - 1][j][1];
                }
            }
        }
        int[] result = new int[3];
        int maxI = 2 * k;
        for (int i = maxI + 1; i < sums.length; i++) {
            if (dp[i][2][1] > dp[maxI][2][1]) {
                maxI = i;
            }
        }
        result[2] = dp[maxI][2][0];
        result[1] = dp[result[2] - k][1][0];
        result[0] = dp[result[1] - k][0][0];
        return result;

        // [1,2,1,2,6,7,5,1]\n2
    }
}
// @lc code=end

