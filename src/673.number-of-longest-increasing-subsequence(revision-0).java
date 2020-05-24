/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int globalMaxCount = 0;
        int globalMaxLen = 0;
        int[] count = new int[nums.length];
        int[] len = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[j] + 1 == len[i]) {
                        count[i] += count[j];
                    } else if (len[j] >= len[i]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (len[i] > globalMaxLen) {
                globalMaxLen = len[i];
                globalMaxCount = count[i];
            } else if (len[i] == globalMaxLen) {
                globalMaxCount += count[i];
            }
        }
        return globalMaxCount;
    }
}
// @lc code=end

