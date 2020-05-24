/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        for (int num : nums) {
            if (num == 0) {
                max = Math.max(max, curr);
                curr = 0;
            } else {
                curr++;
            }
        }
        return Math.max(max, curr);
    }
}
// @lc code=end

