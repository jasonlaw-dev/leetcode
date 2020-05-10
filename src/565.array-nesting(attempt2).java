/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 */

// dfs(int[] nums)

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int first = nums[i];
                int next = first;
                int count = 0;
                do {
                    next = nums[next];
                    count++;
                    visited[next] = true;
                } while (next != first);
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
// @lc code=end

