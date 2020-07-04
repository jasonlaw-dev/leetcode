/*
 * @lc app=leetcode id=1035 lang=java
 *
 * [1035] Uncrossed Lines
 */

// @lc code=start
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int prev = 0;
            for (int j = 0; j < n; j++) {
                int temp = dp[j + 1];
                if (A[i] != B[j]) {
                    dp[j + 1] = Math.max(dp[j], dp[j + 1]);
                } else {
                    dp[j + 1] = 1 + prev;
                }
                prev = temp;
            }
        }
        return dp[n];
    }
}
// @lc code=end

