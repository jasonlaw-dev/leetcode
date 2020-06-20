/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (S < -1000 || S > 1000) return 0;
        int[] count = new int[2001];
        count[nums[0] + 1000]++;
        count[-nums[0] + 1000]++;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int[] next = new int[2001];
            for (int j = 0; j < count.length; j++) {
                if (count[j] > 0) {
                    next[j + num] += count[j];
                    next[j - num] += count[j];
                }
            }
            count = next;
        }
        return count[S + 1000];
    }
}
// @lc code=end

