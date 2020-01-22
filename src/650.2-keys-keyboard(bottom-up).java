/*
 * @lc app=leetcode id=650 lang=java
 *
 * [650] 2 Keys Keyboard
 */

// @lc code=start
class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int k = 2; k <= i / 2; k++) {
                if (i % k == 0) {
                    int j = i / k;
                    dp[i] = Math.min(dp[i], dp[j] + k);
                    break;
                }
            }
        }
        return dp[n];
    }
}
// @lc code=end

