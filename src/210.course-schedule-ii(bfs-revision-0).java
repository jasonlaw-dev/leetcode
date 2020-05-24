import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> paths = new ArrayList<>();
        int[] inEdges = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            paths.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            inEdges[prerequisites[i][0]]++;
            paths.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inEdges[i] == 0) {
                queue.add(i);
            }
        }
        int[] order = new int[numCourses];
        int orderId = 0;
        while (!queue.isEmpty()) {
            int preReq = queue.poll();
            order[orderId++] = preReq;
            for (int course : paths.get(preReq)) {
                if (--inEdges[course] == 0) {
                    queue.offer(course);
                }
            }
        }
        if (orderId != numCourses) {
            return new int[]{};
        }
        return order;
    }
}
// @lc code=end

