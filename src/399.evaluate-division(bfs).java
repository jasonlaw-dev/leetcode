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
            List<String> pair = queries.get(i);
            String left = pair.get(0);
            String right = pair.get(1);
            if (!graph.containsKey(left) || !graph.containsKey(right)) {
                results[i] = -1.0;
                continue;
            }
            if (left.equals(right)) {
                results[i] = 1.0;
                continue;
            }
            Set<String> visited = new HashSet<>();
            boolean found = false;
            Deque<String> queue = new ArrayDeque<>();
            queue.offer(left);
            while (!queue.isEmpty()) {
                String key = queue.poll();
                visited.add(key);
                Map<String, Double> map = graph.get(key);
                for (String neighbor : map.keySet()) {
                    double val = (key == left ? 1 : graph.get(left).get(key)) * map.get(neighbor);
                    if (neighbor.equals(right)) {
                        found = true;
                        results[i] = val;
                        break;
                    } else if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        graph.get(left).put(neighbor, val);
                        graph.get(neighbor).put(left, 1 / val);
                    }
                }
                if (found) break;
            }
            if (!found) {
                results[i] = -1.0;
            }
        }
        return results;
    }
}
// @lc code=end

