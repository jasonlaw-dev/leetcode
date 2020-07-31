import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] timestamps = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> con : connections) {
            int i = con.get(0);
            int j = con.get(1);
            graph.get(i).add(j);
            graph.get(j).add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, timestamps, 1, 0, -1, res);
        return res;
    }
    private int dfs(List<List<Integer>> graph, int[] timestamps, int time, int curr, int prev, List<List<Integer>> res) {
        if (timestamps[curr] > 0) {
            return timestamps[curr];
        }
        timestamps[curr] = time;
        for (int next : graph.get(curr)) {
            if (next != prev) {
                int nextTime = dfs(graph, timestamps, time + 1, next, curr, res);
                if (nextTime > time) {
                    res.add(Arrays.asList(curr, next));
                }
                timestamps[curr] = Math.min(timestamps[curr], nextTime);
            }
        }
        return timestamps[curr];
    }
}
// @lc code=end

