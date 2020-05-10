import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            graph.get(dislike[0]-1).add(dislike[1]-1);
            graph.get(dislike[1]-1).add(dislike[0]-1);
        }
        int[] group = new int[N + 1];

        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && graph.get(i).size() > 0) {
                if (!helper(graph, group, i, -1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean helper(List<List<Integer>> graph, int[] group, int curr, int g) {
        group[curr] = g;
        for (int next : graph.get(curr)) {
            if (group[next] == 0) {
                if (!helper(graph, group, next, -g)) {
                    return false;
                }
            } else if (group[next] == g) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

