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
        if (nums.length == 0) {
            return result;   
        }
        int left = firstGreaterEqual(nums, target);
        if (nums[left] == target) {
            result[0] = left;
            int right = firstGreaterEqual(nums, target + 1);
            result[1] = nums[right] > target ? right - 1 : right;
        }
        return result;
    }
    public int firstGreaterEqual(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

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

