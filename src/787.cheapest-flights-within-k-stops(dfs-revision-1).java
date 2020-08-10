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
    int MAX = 100 * 10000 + 1;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(flight);
        }
        int res = dfs(graph, src, dst, K + 1, 0, MAX, new boolean[n]);
        return res >= MAX ? -1 : res;
    }
    private int dfs(List<List<int[]>> graph, int src, int dst, int stops, int cost, int min, boolean[] visited) {
        if (src == dst) {
            return cost;
        }
        if (stops == 0) {
            return MAX;
        }
        visited[src] = true;
        for (int[] flight : graph.get(src)) {
            if (!visited[dst] && cost + flight[2] < min) {
                min = Math.min(min, dfs(graph, flight[1], dst, stops - 1, cost + flight[2], min, visited));
            }
            
        }
        visited[src] = false;
        return min;
    }
}
// @lc code=end

