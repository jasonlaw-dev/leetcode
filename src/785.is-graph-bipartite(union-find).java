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
        boolean[] setA = new boolean[graph.length];
        boolean[] setB = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            boolean[] set1, set2;
            if (setA[i]) {
                set1 = setA;
                set2 = setB;
            } else {
                set2 = setA;
                set1 = setB;
            }
            if (!bfs(graph, set1, set2, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean bfs(int[][] graph, boolean[] set1, boolean[] set2, int i) {
        if (set2[i]) {
            return false;
        }
        if (set1[i]) {
            return true;
        }
        set1[i] = true;
        for (int j : graph[i]) {
            if (!bfs(graph, set2, set1, j)) {
                return false;
            }
        }
        return true;
    }

}
// @lc code=end

