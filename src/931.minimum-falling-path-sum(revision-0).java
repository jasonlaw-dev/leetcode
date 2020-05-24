/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        int[] dp = A[0];
        for (int i = 1; i < N; i++) {
            int[] next = new int[N];
            for (int j = 0; j < N; j++) {
                next[j] = Integer.MAX_VALUE;
                for (int k = Math.max(0, j - 1); k < N && k <= j + 1; k++) {
                    next[j] = Math.min(next[j], A[i][j] + dp[k]);
                }
            }
            dp = next;
        }
        int res = Integer.MAX_VALUE;
        for (int num : dp) res = Math.min(res, num);
        return res;
    }
}
// @lc code=end

