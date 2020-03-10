import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// visited


// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        Map<Integer, Integer> dist = new HashMap<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new HashMap<>());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {K, 0});
        for (int[] time : times) {
            graph.get(time[0]).put(time[1], time[2]);
        }

        while (!pq.isEmpty()) {
            int[] min = pq.poll();
            int from = min[0];
            int currDist = min[1];
            if (dist.containsKey(from)) {
                continue;
            }
            dist.put(from, currDist);
            for (Map.Entry<Integer, Integer> entry : graph.get(from).entrySet()) {
                int to = entry.getKey();
                int time = entry.getValue();
                if (!dist.containsKey(to)) {
                    pq.offer(new int[] { to, currDist + time });
                }
            }
        }
        if (dist.size() != N) return -1;
        int max = 0;
        for (int val : dist.values()) {
            max = Math.max(val, max);
        }
        return max;
    }
}
// @lc code=end

