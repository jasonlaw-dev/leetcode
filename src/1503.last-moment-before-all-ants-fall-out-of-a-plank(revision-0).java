/*
 * @lc app=leetcode id=1503 lang=java
 *
 * [1503] Last Moment Before All Ants Fall Out of a Plank
 */

// @lc code=start
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        for (int i : left) {
            res = Math.max(res, i);
        }
        for (int i : right) {
            res = Math.max(res, n - i);
        }
        return res;       
    }
}
// @lc code=end

