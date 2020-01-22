/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        int[][] memo = new int[m][nums.length];
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return splitArray(nums, m - 1, nums.length - 1, memo, sums);
    }

    public int splitArray(int[] nums, int cuts, int end, int[][] memo, int[] sums) {
        if (memo[cuts][end] > 0) {
            return memo[cuts][end];
        }
        if (cuts == 0) {
            memo[cuts][end] = sums[end + 1];
        } else {
            memo[cuts][end] = Integer.MAX_VALUE;
            for (int i = cuts - 1; i < end; i++) {
                int val = splitArray(nums, cuts - 1, i, memo, sums);
                memo[cuts][end] = Math.min(memo[cuts][end], Math.max(val, sums[end + 1] - sums[i + 1]));
                if (val > sums[end + 1] - sums[i + 1]) {
                    break;
                }
            }
        }
        return memo[cuts][end];
    }
}
// @lc code=end

