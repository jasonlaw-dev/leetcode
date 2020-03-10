/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */

// NOTE: think about edge cases!!!

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        if (n <= 3) {
            return n - 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
            }
        }
        return dp[n];
    }
}
// @lc code=end

