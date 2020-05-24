/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int start, int end, int k) {
        swap(nums, end, start + (int)((end - start + 1) * Math.random()));
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] < nums[end]) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, end);
        int count = end - i + 1;
        if (count < k) {
            return quickSelect(nums, start, i - 1, k - count);
        } else if (count > k) {
            return quickSelect(nums, i + 1, end, k);
        }
        return nums[i];
    }

    void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
// @lc code=end

