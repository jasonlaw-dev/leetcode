/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        return bt(n, new int[n + 1]);
    }
    public int bt(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            memo[n] = Math.min(bt(n - i * i, memo) + 1, memo[n]);
        }
        return memo[n];
    }
}
// @lc code=end

