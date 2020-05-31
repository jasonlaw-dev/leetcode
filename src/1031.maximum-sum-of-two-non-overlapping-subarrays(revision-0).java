/*
 * @lc app=leetcode id=1031 lang=java
 *
 * [1031] Maximum Sum of Two Non-Overlapping Subarrays
 */

// @lc code=start
class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] sums = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sums[i + 1] = sums[i] + A[i];
        }
        return Math.max(findMax(sums, L, M), findMax(sums, M, L));
    }
    public int findMax(int[] sums, int leftSize, int rightSize) {
        int[] leftSums = new int[sums.length - leftSize];
        int[] rightSums = new int[sums.length - rightSize];
        for (int i = 0; i < sums.length - leftSize; i++) {
            leftSums[i] = Math.max(sums[i + leftSize] - sums[i], i == 0 ? 0 : leftSums[i - 1]);
        }
        for (int i = sums.length - rightSize - 1; i >= 0; i--) {
            rightSums[i] = Math.max(sums[i + rightSize] - sums[i], i == sums.length - rightSize - 1 ? 0 : rightSums[i+1]);
        }
        int res = 0;
        for (int i = leftSize; i < sums.length - rightSize; i++) {
            res = Math.max(res, leftSums[i - leftSize] + rightSums[i]);
        }
        return res;
    }
}
// @lc code=end

