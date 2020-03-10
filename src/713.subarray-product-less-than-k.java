/*
 * @lc app=leetcode id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 1) return 0;
        int product = 1;
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < nums.length) {
            product *= nums[j++];
            while (product >= k && i < j) {
                product /= nums[i++];
            }
            if (product < k) {
                count += j - i;
            }
        }
        return count;
    }
}
// @lc code=end

