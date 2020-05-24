/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int lower = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    lower++;
                }
            }
            if (lower > mid) {
                high = mid;  
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
// @lc code=end

