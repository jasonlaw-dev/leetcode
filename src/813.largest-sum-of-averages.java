/*
 * @lc app=leetcode id=813 lang=java
 *
 * [813] Largest Sum of Averages
 */

// we need presums


// @lc code=start
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int[] sums = new int[A.length];
        sums[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sums[i] = sums[i-1] + A[i];
        }
        double[] dp = new double[A.length];
        for (int group = 1; group <= K; group++) {
            if (group == 1) {
                for (int i = 0; i < A.length; i++) {
                    dp[i] = sums[i] * 1.0 / (i + 1);
                }
            } else {
                for (int i = A.length - 1; i >= group - 1; i--) {
                    for (int s = group - 1; s <= i; s++) {
                        dp[i] = Math.max(dp[i], dp[s - 1] + (sums[i] - sums[s - 1]) * 1.0 / (i - s + 1));
                    }
                }
            }
        }
        return dp[A.length - 1];
    }
}
// @lc code=end

