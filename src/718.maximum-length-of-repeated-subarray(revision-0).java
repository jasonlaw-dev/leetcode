/*
 * @lc app=leetcode id=718 lang=java
 *
 * [718] Maximum Length of Repeated Subarray
 */

// @lc code=start
class Solution {
    public int findLength(int[] A, int[] B) {
        int[] dp = new int[B.length + 1];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[j + 1] = 1 + dp[j];
                    max = Math.max(max, dp[j + 1]);
                } else {
                    dp[j + 1] = 0;
                }
            }
        }
        return max;
    }
}
// @lc code=end

