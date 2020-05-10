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
    int[][] memo;
    public int superEggDrop(int K, int N) {
        memo = new int[K + 1][N + 1];
        return drop(K, N);
    }
    public int drop(int K, int N) {
        if (K == 1 || N <= 1) {
            return N;
        }
        if (memo[K][N] != 0) return memo[K][N];
        int left = 1;
        int right = (N + 1) / 2;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int diff = drop(K, N - mid) - drop(K - 1, mid - 1);
            if (diff >= 0) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        memo[K][N] = 1 + Math.max(drop(K - 1, left - 1), drop(K, N - left));

        return memo[K][N];
    };
}
// @lc code=end


