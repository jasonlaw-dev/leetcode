import java.util.Arrays;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 * 
 * O(n^2), use dynamic programming to solve
 * O(n log n) use binary search
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        int len = 1;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int idx = binSearch(dp, 0, len - 1, nums[i]);
            dp[idx] = nums[i];
            if (idx == len) len++;
        }
        return len;
    }

    // [1, 3, 5]
    public int binSearch(int[] dp, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (dp[mid] > target) {
                high = mid - 1;
            } else if (dp[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
// @lc code=end

