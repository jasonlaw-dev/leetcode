/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) return;
        int min = nums[0];
        int max = nums[0];
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        while (min < max) { // revisit that
            int mid = min + (max - min) / 2;
        }
    }
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

