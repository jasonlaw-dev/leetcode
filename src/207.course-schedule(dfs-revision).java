import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] tuple : prerequisites) {
            graph.get(tuple[1]).add(tuple[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!helper(graph, visited, stack, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean helper(List<List<Integer>> graph, boolean[] visited, boolean[] stack, int curr) {
        if (stack[curr]) return false;
        if (visited[curr]) return true;
        visited[curr] = true;
        stack[curr] = true;
        for (int next : graph.get(curr)) {
            if (!helper(graph, visited, stack, next)) {
                return false;
            }
        }
        stack[curr] = false;
        return true;
    }
}
// @lc code=end

