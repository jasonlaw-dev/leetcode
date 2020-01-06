/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
// 5, 1, 2, 3, 4
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                break;
            }
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) { // be careful!
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
// @lc code=end

