import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000 || nums.length == 0) return 0;
        Integer[][] memo = new Integer[nums.length][2001];
        int[] rightSum = new int[nums.length];
        rightSum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = nums[i] + rightSum[i + 1];
        }
        return bt(nums, S, rightSum, 0, 0, memo);
    }

    private int bt(int[] nums, int S, int[] rightSum, int i, int sum, Integer[][] memo) {
        if (i == nums.length) {
            return sum == S ? 1 : 0;
        }
        if (memo[i][sum + 1000] != null) {
            return memo[i][sum + 1000];
        }
        int result;
        if (Math.abs(S - sum) > rightSum[i]) {
            result = 0;
        } else {
            result = bt(nums, S, rightSum, i + 1, sum + nums[i], memo) + bt(nums, S, rightSum, i + 1, sum - nums[i], memo);
        }
        memo[i][sum + 1000] = result;
        return result;
    }
}
// @lc code=end

