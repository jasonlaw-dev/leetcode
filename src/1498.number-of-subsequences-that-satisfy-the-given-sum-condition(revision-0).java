import java.util.Arrays;

/*
 * @lc app=leetcode id=1498 lang=java
 *
 * [1498] Number of Subsequences That Satisfy the Given Sum Condition
 */

// @lc code=start
class Solution {
    int[] dp = new int[100001];
    int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0, j = nums.length - 1; i <= j; i++) {
            while (i <= j && nums[j] > target - nums[i]) {
                j--;
            }
            if (i <= j) {
                count = (count + pow(j - i)) % mod;
            }
        }
        return count;
    }
    private int pow(int i) {
        if (i == 0) {
            return 1;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        dp[i] = (pow(i - 1) * 2) % mod;
        return dp[i];
    }
}
// @lc code=end

