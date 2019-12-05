/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        return bSearch(nums, target, 0, nums.length - 1);
    }

    public int bSearch(int[] nums, int target, int start, int end) {
        if (end < start) {
            return -1;
        }
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = (start + end) / 2;
        if (nums[start] <= target && target <= nums[mid]) {
            return bSearch(nums, target, start, mid);
        }
        if (nums[mid+1] <= target && target <= nums[end]) {
            return bSearch(nums, target, mid + 1, end);
        }
        if (nums[mid] < nums[start]) {
            return bSearch(nums, target, start, mid);
        }
        if (nums[end] < nums[mid+1]) {
            return bSearch(nums, target, mid + 1, end);
        }
        return -1;
    }
}
// @lc code=end

