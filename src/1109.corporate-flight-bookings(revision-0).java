/*
 * @lc app=leetcode id=1109 lang=java
 *
 * [1109] Corporate Flight Bookings
 */

// @lc code=start
// [0, 10, 45, -10, -20, 0]
// [0, 10, 55, 45, 25, 25]
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] range = new int[n + 1];
        for (int[] b : bookings) {
            range[b[0] - 1] += b[2];
            range[b[1]] -= b[2];
        }
        int[] res = new int[n];
        res[0] = range[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] + range[i];
        }
        return res;
    }
}
// @lc code=end

