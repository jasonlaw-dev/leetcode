/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int fillIndex = m + n - 1; fillIndex >= 0; fillIndex--) {
            if (j < 0 || i >= 0 && nums1[i] >= nums2[j]) {
                nums1[fillIndex] = nums1[i--];
            } else {
                nums1[fillIndex] = nums2[j--];
            }
        } 
    }
}
// @lc code=end

