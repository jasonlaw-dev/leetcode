/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution {
    // 2 4 6 4 8 10 9 10
    // min = 4
    // max = 10
    //

    // 2 3 9 1 10
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                max = Math.max(max, nums[i - 1]);
                min = Math.min(min, nums[i]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (start == -1 && nums[i] > min) {
                start = i;
            }
            if (nums[i] < max) {
                end = i;
            }
        }
        return end - start + 1;
    }
}
// @lc code=end

