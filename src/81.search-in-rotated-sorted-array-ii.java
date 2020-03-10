/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// 1 2 3
// 1 1 1
// 1 1 2
// 2 1 1

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    public boolean search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return false;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return true;
        }
        boolean searchLeft = false;
        boolean searchRight = false;
        if (nums[start] < nums[mid]) {
            if (target >= nums[start] && target < nums[mid]) {
                searchLeft = true;
            } else {
                searchRight = true;
            }
        } else if (nums[mid] != nums[end]) {
            if (target > nums[mid] && target <= nums[end] || nums[start] == nums[mid]) {
                searchRight = true;
            } else {
                searchLeft = true;
            }
        } else {
            searchLeft = true;
            searchRight = true;
        }
        return searchLeft && search(nums, target, start, mid - 1) || searchRight && search(nums, target, mid + 1, end);
    }
}
// @lc code=end

