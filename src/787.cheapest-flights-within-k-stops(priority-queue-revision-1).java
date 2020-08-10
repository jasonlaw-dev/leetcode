import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(flight);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[]{ src, 0, 0 });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == dst) {
                return curr[2];
            }
            if (curr[1] == K + 1) {
                continue;
            }
            for (int[] flight : graph.get(curr[0])) {
                pq.add(new int[]{ flight[1], curr[1] + 1, flight[2] + curr[2] });
            }
        }
        return -1;
    }
}
// @lc code=end

