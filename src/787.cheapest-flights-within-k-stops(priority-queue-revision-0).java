import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(flight);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{ 0, src, K + 1 });
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int cost = node[0];
            int loc = node[1];
            int remain = node[2];
            if (node[1] == dst) {
                return node[0];
            }
            if (remain > 0) {
                for (int[] flight : graph.get(loc)) {
                    pq.add(new int[] { cost + flight[2], flight[1], remain - 1 });
                }
            }
        }
        return -1;
    }
}
// @lc code=end

