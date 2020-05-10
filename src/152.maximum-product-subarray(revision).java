/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// [2,3,-2,4]
// 2 3 -2 4
//   6 -6 -8
 
// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(nums[i], min * nums[i]);
            max = Math.max(nums[i], max * nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}
// @lc code=end

