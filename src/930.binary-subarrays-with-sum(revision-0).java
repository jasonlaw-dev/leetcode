/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        if (A.length == 0) return 0;
        int res = 0;
        for (int i = 0, j = 0, k = -1; j < A.length; j++) {
            S -= A[j];
            while ((S < 0 || A[i] == 0) && i < j) {
                k = S < 0 ? i : k;
                S += A[i++];
            }
            if (S == 0) {
                res += i - k;
            }
        }
        return res;
    }
}
// @lc code=end

