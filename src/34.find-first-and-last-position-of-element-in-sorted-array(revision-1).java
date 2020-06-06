/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findFirst(nums, target);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1,-1};
        }
        int right = findFirst(nums, target + 1);
        return new int[]{left, right - 1};
    }
    private int findFirst(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] >= target) {
                j = mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            }
        }
        return i;
    }
}
// @lc code=end

