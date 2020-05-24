import java.util.Stack;

/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */

// 1 5 0 7 6

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int prevDiff = nums[1] - nums[0];
        int count = prevDiff == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i-1];
            if (diff > 0 && prevDiff <= 0 || diff < 0 && prevDiff >= 0) {
                count++;
                prevDiff = diff;
            }
        }
        return count;
    }
}
// @lc code=end

