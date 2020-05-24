import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */

// @lc code=start
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> results = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) {
                return b[2] - a[2];
            }
            return a[1] - b[1];
        });
        int i = 0;
        int currX = 0;
        int currY = 0;
        while (i != buildings.length || !pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[1] <= currX) {
                pq.poll();
            }
            while (i < buildings.length && buildings[i][0] <= currX) {
                pq.offer(buildings[i]);
                i++;
            }
            int nextY = pq.isEmpty() ? 0 : pq.peek()[2];
            if (nextY != currY) {
                currY = nextY;
                results.add(Arrays.asList(currX, currY));
            }
            currX = Math.min(pq.isEmpty() ? Integer.MAX_VALUE : pq.peek()[1], i != buildings.length ? buildings[i][0] : Integer.MAX_VALUE);
        }
        return results;
    }
}
// @lc code=end

