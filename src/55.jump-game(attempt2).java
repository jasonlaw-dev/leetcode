/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 * 
 * NOTE: there is an O(n) solution, try converting top down to bottom up to avoid stack overhead
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length];
        memo[nums.length - 1] = Boolean.TRUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            int maxSteps = Math.min(nums[i], nums.length - i - 1);
            for (int steps = 1; steps <= maxSteps; steps++) {
                if (memo[i + steps] != null && memo[i + steps] == true) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[0] != null && memo[0] == true;
    }
}
// @lc code=end

