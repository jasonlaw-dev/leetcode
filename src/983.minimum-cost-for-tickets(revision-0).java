/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
      if (days.length == 0) return 0;
      int[] passes = {1, 7, 30};
      boolean[] travel = new boolean[366];
      int[] dp = new int[366];
      for (int day : days) {
        travel[day] = true;
      }
      for (int day = 1; day <= 365; day++) {
        if (!travel[day]) {
          dp[day] = dp[day - 1];
        } else {
          dp[day] = Integer.MAX_VALUE;
          for (int passType = 0; passType < 3; passType++) {
            dp[day] = Math.min(dp[day], costs[passType] + (day - passes[passType] >= 0 ? dp[day - passes[passType]] : 0));
          }
        }
      }
      return dp[365];
    }
}
// @lc code=end
