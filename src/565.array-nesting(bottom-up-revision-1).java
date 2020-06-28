/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int[] dp = new int[nums.length];
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int curr = i;
                do {
                    dp[i]++;
                    visited[curr] = true;
                    curr = nums[curr];
                } while (nums[curr] != i);
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }
}
// @lc code=end

