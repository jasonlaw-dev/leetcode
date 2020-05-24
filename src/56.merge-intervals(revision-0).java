import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        List<int[]> results = new ArrayList<>();
        for (int[] interval : intervals) {
            if (results.size() > 0) {
                int[] prev = results.get(results.size() - 1);
                if (interval[0] >= prev[0] && interval[0] <= prev[1]) {
                    prev[1] = Math.max(prev[1], interval[1]); // NOTE: remember to use MAX
                } else {
                    results.add(interval);
                }
            } else {
                results.add(interval);
            }
        }
        return results.toArray(new int[results.size()][]);
    }
}
// @lc code=end

