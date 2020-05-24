/*
 * @lc app=leetcode id=845 lang=java
 *
 * [845] Longest Mountain in Array
 * 
 * Goal is to complete in O(N) time and O(1) space
 * trend = 0
 * length = 0
 * 
 * When should we restart?
 * when currTrend == 2
 * 
 * -1 -1 len++
 * -1  0 update res, len = 0
 * -1  1 update res, len = 2
 *  0 -1 len = 0, currTrend = 0
 *  0  0 len = 0
 *  0  1 len = 2
 *  1 -1 len++
 *  1  0 len = 0
 *  1  1 len++
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] A) {
        int res = 0;
        int up = 0;
        int down = 0;
        for (int i = 1; i < A.length; i++) {
            if (down > 0 && A[i] > A[i - 1] || A[i] == A[i - 1]) {
                up = down = 0;
            }
            if (A[i] > A[i - 1]) {
                up++;
            } else if (A[i] < A[i - 1]) {
                down++;
            }
            if (up > 0 && down > 0) {
                res = Math.max(res, up + down + 1);
            }
        }
        return res;
    }
}
// @lc code=end

