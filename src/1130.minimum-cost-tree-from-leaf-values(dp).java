/*
 * @lc app=leetcode id=1130 lang=java
 *
 * [1130] Minimum Cost Tree From Leaf Values
 */

// @lc code=start
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int N = arr.length;
        int[][][] dp = new int[N][N][2]; // start, end, [max, sum]
        for (int i = 0; i < N; i++) {
            dp[i][i][0] = arr[i];
        }
        for (int len = 2; len <= N; len++) {
            for (int i = 0; i < N - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j][0] = Math.max(dp[i][i][0], dp[i + 1][j][0]);
                int sum = Integer.MAX_VALUE;
                for (int k = i + 1; k <= j; k++) {
                    int[] left = dp[i][k - 1];
                    int[] right = dp[k][j];
                    sum = Math.min(sum, left[1] + right[1] + left[0] * right[0]);
                }
                dp[i][j][1] = sum;
            }
        }
        return dp[0][N - 1][1];
    }
}
// @lc code=end

