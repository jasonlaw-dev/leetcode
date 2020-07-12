/*
 * @lc app=leetcode id=845 lang=java
 *
 * [845] Longest Mountain in Array
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] A) {
        int up = 0;
        int down = 0;
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            int diff = A[i] - A[i - 1];
            if (down > 0 && diff > 0 || diff == 0) {
                up = down = 0;
            }
            if (diff > 0) {
                up++;
            } else if (diff < 0) {
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

