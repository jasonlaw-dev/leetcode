/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return bt(nums, visited, 0);
    }
    public boolean bt(int[] nums, boolean[] visited, int i) {
        if (i == nums.length - 1) {
            return true;
        }
        if (nums[i] == 0 || visited[i]) {
            return false;
        }
        visited[i] = true;
        for (int steps = Math.min(nums[i], nums.length - i - 1); steps >= 1; steps--) {
            boolean result = bt(nums, visited, i + steps);
            if (result) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

