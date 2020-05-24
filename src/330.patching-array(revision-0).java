/*
 * @lc app=leetcode id=330 lang=java
 *
 * [330] Patching Array
 * 
 * if we scan from left to right
 * we can get the maximum possible num by summing them up,
 * then we can fill the missing numbers?
 */

// @lc code=start
class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i = 0;
        int added = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                added++;
            }
        }
        return added;
    }
}
// @lc code=end

