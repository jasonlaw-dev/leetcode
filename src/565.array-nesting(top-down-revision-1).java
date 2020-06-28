/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int[] memo = new int[nums.length];
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dfs(nums, i, memo, visited));
        }
        return res;
    }
    private int dfs(int[] nums, int i, int[] memo, boolean[] visited) {
        if (memo[i] != 0) {
            return memo[i];
        }
        if (visited[i]) {
            return 0;
        }
        visited[i] = true;
        memo[i] = 1 + dfs(nums, nums[i], memo, visited);
        return memo[i];
    }
}
// @lc code=end

