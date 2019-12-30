import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int num: nums) sum += num;
        if(sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
// @lc code=end

