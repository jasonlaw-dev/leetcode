/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length == 0) return; 
        int n = nums.length;
        int median = findMedian(nums, 0, nums.length - 1, (nums.length + 1) / 2);
        int left = 0;
        int i = 0;
        int right = nums.length - 1;
        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            } else {
                i++;
            }
        }
    }

    int newIndex(int i, int n) {
        return (1 + i * 2) % (n | 1);
    }

    public int findMedian(int[] nums, int start, int end, int k) {
        int i = start;
        swap(nums, end, start + (int)(Math.random() * (end - start + 1)));
        for (int j = start; j < end; j++) {
            if (nums[j] >= nums[end]) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, end);
        int count = i - start + 1;
        if (count > k) {
            return findMedian(nums, start, i - 1, k);
        } else if (count < k) {
            return findMedian(nums, i + 1, end, k - count);
        } else {
            return nums[i];
        }
    }

    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

