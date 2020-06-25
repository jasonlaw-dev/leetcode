/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= s) {
                minLen = Math.min(minLen, j - i);
                sum -= nums[i++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
// @lc code=end

