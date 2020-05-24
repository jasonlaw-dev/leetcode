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
            if (!canFinish(graph, i, visited, stack)) {
                return false;
            }
        }
        return true;
    }
    public boolean canFinish(List<List<Integer>> graph, int course, boolean[] visited, boolean[] stack) {
        if (stack[course]) {
            return false;
        }
        if (visited[course]) {
            return true;
        }
        visited[course] = true;
        stack[course] = true;
        for (int nextCourse : graph.get(course)) {
            if (!canFinish(graph, nextCourse, visited, stack)) {
                return false;
            }
        }
        stack[course] = false;
        return true;
    }
}
// @lc code=end

