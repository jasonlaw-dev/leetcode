/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] memo = new int[graph.length];
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == 0) {
                if (!dfs(graph, memo, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph, int[] memo, int i, int expected) {
        if (memo[i] != 0) {
            return memo[i] == expected;
        }
        memo[i] = expected;
        for (int next : graph[i]) {
            if (!dfs(graph, memo, next, expected * -1)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

