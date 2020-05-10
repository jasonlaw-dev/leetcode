import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=815 lang=java
 *
 * [815] Bus Routes
 * 
 * 
 * BFS
 * Union find
 * Seen Map contains visited bus stops
 * Queue <- should have the current bus stop
 */

// @lc code=start
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (!map.containsKey(routes[i][j])) {
                    map.put(routes[i][j], new ArrayList<>());
                }
                map.get(routes[i][j]).add(i);
            }
        }

        if (!map.containsKey(S)|| !map.containsKey(T)) {
            return -1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(S);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int from = queue.poll();
                for (int route : map.get(from)) {
                    if (routes[route] == null) continue;
                    for (int to : routes[route]) {
                        if (to == T) {
                            return res;
                        }
                        queue.add(to);
                    }
                    routes[route] = null;
                }
            }
            res++;
        }
        return -1;
    }
}
// @lc code=end

