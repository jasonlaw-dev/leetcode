import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=802 lang=java
 *
 * [802] Find Eventual Safe States
 * find all terminal nodes
 * then find previous node, if only all the edges point to eventually safe nodes, we insert them
 * remove that edge, add to queue
 */



// @lc code=start
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outEdges = new int[graph.length];
        List<Set<Integer>> previous = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            previous.add(new HashSet<>());
        }
        for (int i = 0; i < graph.length; i++) {
            outEdges[i] = graph[i].length;
            if (graph[i].length == 0) {
                queue.add(i);
            }
            for (int j : graph[i]) {
                previous.get(j).add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (int prev : previous.get(node)) {
                if (--outEdges[prev] == 0) {
                    queue.add(prev);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
// @lc code=end

