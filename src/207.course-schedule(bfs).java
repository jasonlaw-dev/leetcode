import java.util.Queue;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// similar idea to topological sort...

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degrees = new int[numCourses]; // number of incoming edges
        for (int[] tuple : prerequisites) {
            degrees[tuple[0]]++;
            graph.get(tuple[1]).add(tuple[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int nextCourse : graph.get(course)) {
                degrees[nextCourse]--;
                if (degrees[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
            count++;
        }
        return count == numCourses;
    }
}
// @lc code=end

