import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();
        int i = 0;
        for (; i < intervals.length && intervals[i][1] < newInterval[0]; i++) {
            results.add(intervals[i]);
        }
        for (; i < intervals.length && intervals[i][0] <= newInterval[1]; i++) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
        }
        results.add(newInterval);
        for (; i < intervals.length; i++) {
            results.add(intervals[i]);
        }
        return results.toArray(new int[results.size()][]);
    }
}
// @lc code=end

