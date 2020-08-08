import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Map<Integer, Integer>> memo = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            memo.add(new HashMap<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        List<Integer> res = new ArrayList<>();
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dfs(graph, i, -1, memo);
            if (temp < max) {
                max = temp;
                res = new ArrayList<>();
            }
            if (temp == max) {
                res.add(i);
            }
        }
        return res;
    }
    private int dfs(List<List<Integer>> graph, int curr, int prev, List<Map<Integer, Integer>> memo) {
        if (prev != -1 && memo.get(prev).containsKey(curr)) {
            return memo.get(prev).get(curr);
        }
        int res = 0;
        for (int next : graph.get(curr)) {
            if (next != prev) {
                res = Math.max(res, dfs(graph, next, curr, memo));
            }
        }
        res++;
        if (prev != -1) {
            memo.get(prev).put(curr, res);
        }
        return res;
    }
}
// @lc code=end

