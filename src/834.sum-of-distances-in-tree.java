import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=834 lang=java
 *
 * [834] Sum of Distances in Tree
 */

// record all edges in a map
// then choose a start point at 0
// use dfs to count number of descendents, store results in a map, while calculating distances
// 

/*
      0[6, 8]
   /      \
1[1,0]   2 [4, 3] // distances = 3 + (8 - 3 - 4) + (6-4)= 6
        /|\
        3 4 5 // distances = 0 + (6 - 0 - 1) + (6 - 1)

        // parentDist - size of current tree + (totalNodes - size of current tree)
*/

// @lc code=start
class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] sizes = new int[N];
        int[] res = new int[N];
        dfs1(0, -1, graph, sizes, res);
        dfs2(0, -1, graph, sizes, res);
        return res;
    }
    public void dfs1(int curr, int parent, List<Set<Integer>> graph, int[] sizes, int[] res) {
        for (int child : graph.get(curr)) {
            if (child != parent) {
                dfs1(child, curr, graph, sizes, res);
                sizes[curr] += sizes[child];
                res[curr] += res[child] + sizes[child];
            }
        }
        sizes[curr]++;
    }
    public void dfs2(int curr, int parent, List<Set<Integer>> graph, int[] sizes, int[] res) {
        for (int child : graph.get(curr)) {
            if (child != parent) {
                res[child] = res[curr] - sizes[child] + sizes[0] - sizes[child];
                dfs2(child, curr, graph, sizes, res);
            }
        }
    }
}
// @lc code=end

