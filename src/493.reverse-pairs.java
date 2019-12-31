/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    public int merge(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = merge(nums, start, mid) + merge(nums, mid + 1, end);
        int[] sortedNums = new int[end - start + 1];

        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) {
                count += mid - i + 1;
                j++;
            }
        }

        // merge sorted parts
        for (int i = start, j = mid + 1, k = 0; k < sortedNums.length; k++) {
            if (i == mid + 1 || j <= end && nums[i] > nums[j]) {
                sortedNums[k] = nums[j++];
            } else {
                sortedNums[k] = nums[i++];
            }
        }
        int i = 0;
        for (int k = start; k <= end; k++) {
            nums[k] = sortedNums[i++];
        }
        return count;
    }
}
// @lc code=end

