/*
 * @lc app=leetcode id=887 lang=java
 *
 * [887] Super Egg Drop
 */


// @lc code=start
class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1]; // dp[k][]
        int m = 0;
        while (dp[m][K] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[m][k] = 1 + dp[m - 1][k] + dp[m - 1][k - 1];
            }
        }
        return m;
    }
}
// @lc code=end


