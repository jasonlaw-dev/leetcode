/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */


// brute force permutation problem : O(n!)5
// @lc code=start


// 3 1 5

/*
   0 1 2
   _ _ _
0 |3 
1 |  1
2 |    5
*/

class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];
        for (int l = 1; l <= nums.length; l++) {
            for (int i = 0; i < nums.length - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MIN_VALUE;
                int leftBound = i == 0 ? 1 : nums[i - 1];
                int rightBound = j == nums.length - 1 ? 1 : nums[j + 1];
                for (int k = i; k <= j; k++) {
                    int leftSum = k == i ? 0 : dp[i][k-1];
                    int rightSum = k == j ? 0 : dp[k+1][j];
                    dp[i][j] = Math.max(dp[i][j], leftSum + rightSum + nums[k] * leftBound * rightBound);
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}
// @lc code=end

