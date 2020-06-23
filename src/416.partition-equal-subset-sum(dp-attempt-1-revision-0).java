import java.util.Arrays;

/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// Brute force O(2^n)


// 2 3 4 5
// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int end = nums.length;
        for (; end >= 2; end -= 2) {
            if (nums[end - 1] != nums[end - 2]) {
                break;
            }
        }
        if (end == 0) return true;
        int[] leftSum = new int[end];
        leftSum[0] = nums[0];
        for (int i = 1; i < end; i++) {
            leftSum[i] = leftSum[i-1] + nums[i];
        }
        int sum = leftSum[end - 1];
        if (sum % 2 == 1) return false;
        int arraySize = 2 * sum + 1; 
        boolean[] dp = new boolean[arraySize];
        dp[nums[0] + sum] = true;
        dp[-nums[0] + sum] = true;
        for (int i = 1; i < end; i++) {
            boolean[] next = new boolean[arraySize];
            int s = -leftSum[i - 1] + sum;
            int e = leftSum[i - 1] + sum;
            for (int k = s; k <= e; k++) {
                if (dp[k]) {
                    next[k + nums[i]] = true;
                    next[k - nums[i]] = true;
                }
            }
            dp = next;
        }
        return dp[sum];
    }
}
// @lc code=end

