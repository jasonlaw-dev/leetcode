import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] pair : intervals) {
            while (!pq.isEmpty() && pair[0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(pair[1]);
            res = Math.max(res, pq.size());
        }
        return res;
    }
}
// @lc code=end

