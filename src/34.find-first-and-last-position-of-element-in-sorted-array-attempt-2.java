/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

/*

*/

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = firstGreaterEqual(nums, target);
        if (left != nums.length && nums[left] == target) {
            result[0] = left;
            int right = firstGreaterEqual(nums, target + 1);
            result[1] = right - 1;
        }
        return result;
    }
    public int firstGreaterEqual(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
// @lc code=end

