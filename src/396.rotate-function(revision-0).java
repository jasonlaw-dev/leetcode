/*
 * @lc app=leetcode id=396 lang=java
 *
 * [396] Rotate Function
 * 
 * lose (n-1) B[n - 1], gain sum(B[0] + B[1] + ... B[n - 2])
 * sum == 15
 * change 15 - 4 * 6
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] A) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            max += A[i] * i;
            sum += A[i];
        }
        int curr = max;
        for (int i = A.length - 1; i > 0; i--) {
            curr = curr + sum - A.length * A[i];
            max = Math.max(max, curr);
        }
        return max;
    }
}
// @lc code=end

