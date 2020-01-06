/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left < right && nums[left] >= nums[right]) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid] || nums[mid] > nums[right]) {
                return findMin(nums, mid + 1, right);
            }
            if (nums[left] > nums[mid]) {
                return findMin(nums, left, mid);
            }
            return Math.min(findMin(nums, left, mid), findMin(nums, mid + 1, right));
        }
        return nums[left];
    }
}
// @lc code=end

