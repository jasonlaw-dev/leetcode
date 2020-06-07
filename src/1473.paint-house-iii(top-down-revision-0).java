/*
 * @lc app=leetcode id=1473 lang=java
 *
 * [1473] Paint House III
 */

// @lc code=start
class Solution {
    int m;
    int n;
    int target;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.m = m;
        this.n = n;
        this.target = target;
        long val = dfs(houses, cost, new long[m][n + 1][target + 1], 0, 0, target);
        return val >= Integer.MAX_VALUE ? -1 : (int) val;
    }
    private long dfs(int[] houses, int[][] cost, long[][][] dp, int i, int j, int k) {
        if (i == m) {
            return k == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (k < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }
        if (houses[i] != 0) {
            dp[i][j][k] = dfs(houses, cost, dp, i + 1, houses[i], k - (houses[i] == j ? 0 : 1));
        } else {
            dp[i][j][k] = Integer.MAX_VALUE;
            for (int next = 1; next <= n; next++) {
                dp[i][j][k] = Math.min(dp[i][j][k], cost[i][next - 1] + dfs(houses, cost, dp, i + 1, next, k - (next == j ? 0 : 1)));
            }
        }
        return dp[i][j][k];
    }
}
// @lc code=end

