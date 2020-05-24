import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> paths = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            paths.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            paths.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        LinkedList<Integer> order = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(paths, i, order, visited, inStack)) {
                return new int[]{};
            }
        }
        int[] orderArray = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            orderArray[i] = order.pop();
        }
        return orderArray;
    }
    public boolean dfs(List<List<Integer>> paths, int course, LinkedList<Integer> order, boolean[] visited, boolean[] inStack) {
        if (inStack[course]) {
            return false;
        }
        if (visited[course]) {
            return true;
        }
        visited[course] = true;
        inStack[course] = true;
        for (int nextCourse : paths.get(course)) {
            if (!dfs(paths, nextCourse, order, visited, inStack)) {
                return false;
            }
        }
        order.push(course);
        inStack[course] = false;
        return true;
    }

}
// @lc code=end

