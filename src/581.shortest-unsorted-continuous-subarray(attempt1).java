import java.util.Arrays;

/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 * Time (n log n)
 */

// @lc code=start
class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }
        return start == -1 ? 0 : end - start + 1;
    }
}
// @lc code=end

