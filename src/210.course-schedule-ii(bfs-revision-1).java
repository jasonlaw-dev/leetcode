import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inEdges = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            inEdges[pre[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inEdges.length; i++) {
            if (inEdges[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int i = 0;

        while (!queue.isEmpty()) {
            int from = queue.poll();
            res[i] = from;
            i++;
            for (int to : graph.get(from)) {
                if (--inEdges[to] == 0) {
                    queue.add(to);
                }
            }
        }
        if (i == numCourses) {
            return res;
        }
        return new int[0];
    }
}
// @lc code=end

