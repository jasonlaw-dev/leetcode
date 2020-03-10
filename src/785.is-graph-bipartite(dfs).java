import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

/*
0 1 2 3
. 3 3 3
3 3 3 3

*/

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] parent = new int[graph.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (find(parent, i) == find(parent, graph[i][j])) {
                    return false;
                }
                union(parent, graph[i][0], graph[i][j]);
            }
        }
        return true;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    private void union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);
        if (x != y) {
            parent[x] = y;
        }
    }
}
// @lc code=end

