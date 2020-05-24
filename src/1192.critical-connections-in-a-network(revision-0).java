import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start
class Solution {
    int time = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] timestamps = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> con : connections) {
            graph.get(con.get(0)).add(con.get(1));
            graph.get(con.get(1)).add(con.get(0));
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, -1, graph, timestamps, res);
        return res;
    }

    public void dfs(int curr, int prev, List<List<Integer>> graph, int[] timestamps, List<List<Integer>> res) {
        int currTimetamp = time;
        timestamps[curr] = time++;
        for (int next : graph.get(curr)) {
            if (next == prev) continue;
            if (timestamps[next] == 0) {
                dfs(next, curr, graph, timestamps, res);
                if (currTimetamp < timestamps[next]) {
                    res.add(Arrays.asList(curr, next));
                }
            }
            timestamps[curr] = Math.min(timestamps[curr], timestamps[next]);
        }
    }
}
// @lc code=end

