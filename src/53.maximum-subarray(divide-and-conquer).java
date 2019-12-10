/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {

    public int maxSubArrayAcrossMidpoint(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        int leftSum = 0;
        int leftMax = 0;
        for (int i = mid; i >= start; i--) {
            leftSum += nums[i];
            if (i == mid || leftSum > leftMax) {
                leftMax = leftSum;
            }
        }
        int rightSum = 0;
        int rightMax = 0;
        for (int i = mid + 1; i <= end; i++) {
            rightSum += nums[i];
            if (i == mid || rightSum > rightMax) {
                rightMax = rightSum;
            }
        }
        return leftMax + rightMax;
    }

    public int maxSubArray(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        return Math.max(Math.max(
            maxSubArray(nums, start, mid),
            maxSubArray(nums, mid + 1, end)
        ), maxSubArrayAcrossMidpoint(nums, start, end));
    }

    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }
}
// @lc code=end

