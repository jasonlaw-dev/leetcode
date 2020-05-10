import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// need a graph: List<Set<Integer>

// @lc code=start
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        curr.add(0);
        dfs(graph, 0, curr, res);
        return res; 
    }
    public void dfs(int[][] graph, int i, List<Integer> curr, List<List<Integer>> res) {
        if (i == graph.length - 1) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j : graph[i]) {
            curr.add(j);
            dfs(graph, j, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end

