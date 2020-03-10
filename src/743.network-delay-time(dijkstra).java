import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// visited


// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new HashMap<>());
            dist[i] = Integer.MAX_VALUE;
        }
        dist[K] = 0;

        for (int[] time : times) {
            graph.get(time[0]).put(time[1], time[2]);
        }

        while (true) {
            int from = getMin(dist, visited);
            if (from == 0) {
                break;
            }
            visited[from] = true;
            for (Map.Entry<Integer, Integer> entry : graph.get(from).entrySet()) {
                int to = entry.getKey();
                int time = entry.getValue();
                if (!visited[to] && dist[from] + time < dist[to]) {
                    dist[to] = dist[from] + time;
                }
            }
        }
        int maxDist = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDist = Math.max(maxDist, dist[i]);
        }
        return maxDist;
    }

    private int getMin(int[] dist, boolean[] visited) {
        int minIdx = 0;
        for (int i = 1; i < dist.length; i++) {
            if (!visited[i] && dist[i] < dist[minIdx]) {
                minIdx = i;
            }
        }
        return minIdx;
    }
}
// @lc code=end

