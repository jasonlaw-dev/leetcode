import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=554 lang=java
 *
 * [554] Brick Wall
 */
// use heap
// int[startingInterval so far, rowIndex, brickIndex]

// [0, 0,0] [0, 1, 0] .. [0, n-1, 0];   n: number of rows;
// need a way to store currnet point and also number of edges
// initial condition, point = 0, edge = 0;
// then keep polling until the top of the heap has a different point or if heap is empty

// @lc code=start
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < wall.size(); i++) {
            if (wall.get(i).size() > 1) {
                pq.add(new int[] {wall.get(i).get(0), i, 1});
            }
        }
        int maxEdges = 0;
        
        while (!pq.isEmpty()) {
            int start = pq.peek()[0];
            int edges = 0;
            while (!pq.isEmpty() && pq.peek()[0] == start) {
                int[] curr = pq.poll();
                edges++;

                if (curr[2] != wall.get(curr[1]).size() - 1) {
                    curr[0] += wall.get(curr[1]).get(curr[2]);
                    curr[2]++;
                    pq.add(curr);
                }
            }
            maxEdges = Math.max(maxEdges, edges);
        }
        return wall.size() - maxEdges;
    }
}
// @lc code=end

