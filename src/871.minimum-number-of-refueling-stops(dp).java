/*
 * @lc app=leetcode id=871 lang=java
 *
 * [871] Minimum Number of Refueling Stops
 * 
 * backtracking O(N!)
 * can we reduce to n^2?
 * 
 * can we use dynamic programming?
 * problem is that we have another variable - start fuel
 * dp[i] represents [min hops, remaining field]
 */

// @lc code=start
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int[] dp = new int[stations.length + 1]; // dp[i] furthest we can go with i stops;
        dp[0] = startFuel;
        for (int i = 0; i < stations.length; i++) {
          for (int j = i; j >= 0 && dp[j] >= stations[i][0]; j--) {
            dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
          }
        }
        for (int i = 0; i < stations.length; i++) {
          if (dp[i] >= target) {
            return i;
          }
        }
        return -1;
    }
}
// @lc code=end

