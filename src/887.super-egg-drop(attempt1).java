/*
 * @lc app=leetcode id=887 lang=java
 *
 * [887] Super Egg Drop
 */

// dp[i][j] represents: given i steps, what's the min number of moves when we have j floors
// when i == 1, dp[1][j] = j
// when i == 2 , dp[2][j] = find 1 <= k <= j to minimize Math.max(egg at k breaks, egg at k not break)
// Math.max(1 + dp[1][k - 1], 1 + dp[2][j - k])
// when k increases, increase in LHS >= decrease in RHS
// what about i > 1 ?, 

// @lc code=start
class Solution {
    public int superEggDrop(int K, int N) {
        int[] prev = new int[N + 1];
        int[] curr = null;
        // int[] diff = null;
        for (int j = 1; j <= N; j++) {
            prev[j] = j;
        }
        for (int i = 2; i <= K; i++) {
            curr = new int[N + 1];
            // diff = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                curr[j] = Integer.MAX_VALUE;
                
                int left = 1;
                int right = (j + 1) / 2;
                while (left < right) {
                    int mid = (left + right + 1) / 2;
                    int diff = curr[j - mid] - prev[mid - 1];
                    if (diff >= 0) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                curr[j] = Math.max(1 + prev[left - 1], 1 + curr[j - left]);
                // for (int k = 1; k <= (j+1) / 2; k++) {
                //     curr[j] = Math.min(curr[j], Math.max(1 + prev[k - 1], 1 + curr[j - k]));
                // }
            }
            prev = curr;
        }
        return prev[N];
    }
}
// @lc code=end
