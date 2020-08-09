import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] pair : intervals) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + 1);
            map.put(pair[1], map.getOrDefault(pair[1], 0) - 1);
        }
        int res = 0;
        int con = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            con += entry.getValue();
            res = Math.max(res, con);
        }
        return res;
    }
}
// @lc code=end

