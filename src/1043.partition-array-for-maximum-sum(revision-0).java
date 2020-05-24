/*
 * @lc app=leetcode id=1043 lang=java
 *
 * [1043] Partition Array for Maximum Sum
 */

 // [0,5,3,0]

// @lc code=start
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length;
        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 1; j <= K && i - j + 1 >= 0; j++) {
                int start = i - j + 1;
                max = Math.max(max, A[start]);
                dp[i + 1] = Math.max(dp[i + 1], dp[start] + max * j);
            }
        }
        return dp[A.length];
    }
}
// @lc code=end

