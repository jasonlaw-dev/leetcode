/*
 * @lc app=leetcode id=1473 lang=java
 *
 * [1473] Paint House III
 */

// @lc code=start
class Solution {
    int MAX = 1000001;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][] dp = new int[n][target + 1];
        
        for (int i = 0; i < m; i++) {
            int[][] next = new int[n][target + 1];
            for (int j = 0; j < n; j++) {
                Arrays.fill(next[j], MAX);
            }
            for (int j = 0; j < n; j++) {
                if (houses[i] != 0 && houses[i] != j + 1) {
                    continue;
                }
                int paintCost = houses[i] == 0 ? cost[i][j] : 0;
                int maxTarget = Math.min(i + 1, target);
                for (int k = 1; k <= maxTarget; k++) {
                    if (i != 0) {
                        next[j][k] = Math.min(next[j][k], dp[j][k] + paintCost);
                        for (int q = 0; q < n; q++) {
                            if (q != j) {
                                next[j][k] = Math.min(next[j][k], dp[q][k-1] + paintCost);
                            }
                        }
                    } else if (k == 1) {
                        next[j][k] = paintCost;
                    }
                }
            }
            dp = next;
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0 ; j < n; j++) {
            res = Math.min(res, dp[j][target]);
        }
        return res >= MAX ? -1 : res;
    }
}
// @lc code=end

