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
        Boolean[] state = new Boolean[graph.length];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (isSafe(i, graph, state)) {
                res.add(i);
            }
        }
        
        return res;
    }

    public boolean isSafe(int i, int[][] graph, Boolean[] state) {
        if (state[i] != null) {
            return state[i];
        }
        state[i] = false;
        for (int j : graph[i]) {
            if (!isSafe(j, graph, state)) {
                return false;
            }
        }
        state[i] = true;
        return true;
    }
}
// @lc code=end

