import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=436 lang=java
 *
 * [436] Find Right Interval
 * TreeMap, O(n log n)
 */

// @lc code=start
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            res[i] = entry == null ? -1 : entry.getValue();
        }
        return res;
    }
}
// @lc code=end

