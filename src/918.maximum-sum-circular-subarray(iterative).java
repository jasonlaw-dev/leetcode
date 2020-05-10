/*
 * @lc app=leetcode id=918 lang=java
 *
 * [918] Maximum Sum Circular Subarray
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int res = A[0];

        int[] maxSums = new int[A.length];
        maxSums[0] = A[0];

        int minSum = Math.min(0, A[0]);
        int sum = A[0];

        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            res = Math.max(res, sum - minSum);

            minSum = Math.min(minSum, sum);
            maxSums[i] = Math.max(maxSums[i - 1], sum);
        }

        sum = 0;
        for (int i = A.length - 1; i > 0; i--) {
            sum += A[i];
            res = Math.max(res, sum + maxSums[i - 1]);
        }
        return res;
    }
}
// @lc code=end

