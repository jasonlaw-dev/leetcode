import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

// @lc code=start

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> pair = equations.get(i);
            double val = values[i];
            String left = pair.get(0);
            String right = pair.get(1);
            if (!graph.containsKey(left)) {
                graph.put(left, new HashMap<>());
            }
            if (!graph.containsKey(right)) {
                graph.put(right, new HashMap<>());
            }
            graph.get(left).put(right, val);
            graph.get(right).put(left, 1 / val);
        }
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else {
                results[i] = dfs(graph, new HashSet<String>(), start, end);
            }
        }
        return results;
    }
    public double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String start, String end) {
        if (start.equals(end)) {
            return 1;
        }
        if (visited.contains(start)) {
            return -1;
        }
        visited.add(start);
        for (String next : graph.get(start).keySet()) {
            double val = dfs(graph, visited, next, end);
            if (val != -1) {
                graph.get(next).put(end, val);
                graph.get(end).put(next, 1 / val);
                return val * graph.get(start).get(next);
            }
        }
        return -1;
    }
}
// @lc code=end

