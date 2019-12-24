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
        int i = start;
        swap(nums, start + (int)(Math.random() * (end - start + 1)), end);
        int pivotValue = nums[end];
        for (int j = start; j < end; j++) {
            if (nums[j] < pivotValue) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        int count = end - i + 1;
        if (count == k) {
            return nums[i];
        }
        if (count > k) {
            return quickSelect(nums, i + 1, end, k);
        }
        return quickSelect(nums, start, i - 1, k - count);
    }

    void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
// @lc code=end

