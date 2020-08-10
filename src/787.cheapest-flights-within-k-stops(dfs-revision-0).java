import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;
        // Map<Integer, List<int[]>> graph = new HashMap<>();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(flight);
        }
        return dfs(flights, src, dst, K, 0, Integer.MAX_VALUE, graph, new boolean[n]);
    }

    private int dfs(int[][] flights, int src, int dst, int K, int cost, int min, List<List<int[]>> graph, boolean[] visited) {
        if (src == dst) {
            return cost;
        }
        if (K == -1) {
            return -1;
        }
        visited[src] = true;
        for (int[] flight : graph.get(src)) {
            if (!visited[flight[1]] && cost + flight[2] < min) {
                int val = dfs(flights, flight[1], dst, K - 1, cost + flight[2], min, graph, visited);
                if (val != -1) {
                    min = Math.min(min, val);
                }
            }
        }
        visited[src] = false;
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
// @lc code=end

