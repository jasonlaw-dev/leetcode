import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (dfs(edge[0], edge[1], 0, graph)) {
                return edge;
            } else {
                graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
            }
        }
        return null;
    }
    public boolean dfs(int from, int to, int pre, Map<Integer, Set<Integer>> graph) {
        if (from == to) {
            return true;
        }
        if (graph.containsKey(from)) {
            for (int next : graph.get(from)) {
                if (next == pre) continue;
                if (dfs(next, to, from, graph)) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

