/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int prevIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[prevIndex] != nums[i]) {
                nums[prevIndex + 1] = nums[i];
                prevIndex++;
            }
        }
        return prevIndex + 1;
    }
}
// @lc code=end

