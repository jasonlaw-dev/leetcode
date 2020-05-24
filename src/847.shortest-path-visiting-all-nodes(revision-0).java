import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
 * @lc app=leetcode id=847 lang=java
 *
 * [847] Shortest Path Visiting All Nodes
 * 
 * for each node as start
 * go into dfs
 */

// @lc code=start
class Solution {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        if (N == 1) return 0;
        int[][] dp = new int[N][1 << N];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][1 << i] = 0;
            queue.add(new int[]{i, 1 <<i});
        }
        while (!queue.isEmpty()) {
            int[] cand = queue.poll();
            if (cand[1] == (1 << N) - 1) {
                return dp[cand[0]][cand[1]];
            }
            for (int next : graph[cand[0]]) {
                int mask = cand[1] | (1 << next);
                if (dp[next][mask] == -1) {
                    dp[next][mask] = dp[cand[0]][cand[1]] + 1;
                    queue.add(new int[]{next, mask});
                }
            }
        }
        return -1;
    }
}
// @lc code=end

