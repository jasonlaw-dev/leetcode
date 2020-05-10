/*
 * @lc app=leetcode id=462 lang=java
 *
 * [462] Minimum Moves to Equal Array Elements II
 */

 // 1 10 10
 // 7 + 3 + 3

// @lc code=start
class Solution {
    public int minMoves2(int[] nums) {
        int median = findKth(nums, 0, nums.length - 1, nums.length / 2 + 1);
        int res = 0;
        for (int num : nums) res += Math.abs(median - num);
        // System.out.println(median);
        return res;
    }
    public int findKth(int[] nums, int start, int end, int k) {
        swap(nums, end, start + (int)(Math.random() * (end - start + 1)));
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        int count = i - start + 1;
        if (count < k) {
            return findKth(nums, i + 1, end, k - count);
        }
        if (count > k) {
            return findKth(nums, start, i - 1, k);
        }
        return nums[i];
    }
    private void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
// @lc code=end

