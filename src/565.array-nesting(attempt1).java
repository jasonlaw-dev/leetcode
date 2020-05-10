/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 */

// dfs(int[] nums)

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (memo[i] == -1) {
                max = Math.max(max, dfs(nums, i, memo));
            }
        }
        return max;
    }

    public int dfs(int[] nums, int i, int[] memo) {
        if (memo[i] == -1) {
            memo[i] = 0;
            if (nums[i] != i) {
                memo[i] = 1 + dfs(nums, nums[i], memo);
            } else {
                memo[i] = 1;
            }
        }
        return memo[i];
    }
}
// @lc code=end

