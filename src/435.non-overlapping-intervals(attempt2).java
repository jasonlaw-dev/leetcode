import java.util.Arrays;

/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        int count = 0;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] == prev[0]) {
                prev = curr;
                count++;
            } else {
                if (prev[1] > curr[0]) {
                    count++;
                    if (curr[1] < prev[1]) {
                        prev = curr;
                    }
                } else {
                    prev = curr;
                }
            }
        }
        return count;
    }
}
// @lc code=end

