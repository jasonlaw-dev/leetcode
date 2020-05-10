import java.util.Collections;
import java.util.PriorityQueue;

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
      int i = 0;
      int stops = 0;
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      for (; startFuel < target; stops++) {
        while (i < stations.length && startFuel >= stations[i][0]) {
          pq.offer(stations[i++][1]);
        }
        if (pq.isEmpty()) return -1;
        startFuel += pq.poll();
      }

      return stops;
    }
}
// @lc code=end

