import java.util.Arrays;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 1;
        for (int num : nums) {
            int idx = binSearch(dp, 0, len - 1, num);
            dp[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        return len;
    }
    public int binSearch(int[] dp, int low, int high, int num) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (dp[mid] == num) {
                return mid;
            } else if (dp[mid] < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
// @lc code=end

