import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0 ; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(time);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        boolean[] visited = new boolean[N + 1];
        int visitedCount = 0;
        int res = 0;
        pq.add(new int[]{K, 0});
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int from = pair[0];
            int delay = pair[1];
            if (visited[from]) {
                continue;
            }
            visited[from] = true;
            visitedCount++;
            res = Math.max(res, delay);
            if (visitedCount == N) {
                break;
            }
            for (int[] time : graph.get(from)) {
                if (!visited[time[1]]) {
                    pq.add(new int[]{time[1], delay + time[2]});
                }
            }
        }
        return visitedCount == N ? res : -1;
    }
}
// @lc code=end

