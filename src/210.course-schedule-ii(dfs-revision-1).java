import java.util.ArrayList;
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
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        List<Integer> stack = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited, inStack, stack)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.get(numCourses - i - 1);
        }
        return res;
    }
    private boolean dfs(List<List<Integer>> graph, int from, boolean[] visited, boolean[] inStack, List<Integer> stack) {
        if (inStack[from]) {
            return false;
        }
        if (visited[from]) {
            return true;
        }
        visited[from] = true;
        inStack[from] = true;
        for (int to : graph.get(from)) {
            if (!dfs(graph, to, visited, inStack, stack)) {
                return false;
            }
        }
        inStack[from] = false;
        stack.add(from);
        return true;
    }
}
// @lc code=end

