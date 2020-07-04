import java.util.Arrays;

/*
 * @lc app=leetcode id=823 lang=java
 *
 * [823] Binary Trees With Factors
 */

// @lc code=start
class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        int mod = 1000000007;
        Arrays.sort(A);
        long[] dp = new long[A.length];
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            dp[i] = 1;
            int j = 0;
            int k = i - 1;
            while (j <= k) {
                long temp = ((long) A[j]) * A[k];
                if (temp > A[i]) {
                    k--;
                } else if (temp < A[i]) {
                    j++;
                } else {
                    dp[i] += ((dp[j] * dp[k])) * (j == k ? 1 : 2);
                    j++;
                    k--;
                }
            }
            sum = (sum + dp[i]) % mod;
        }
        return (int) sum;
    }
}
// @lc code=end

