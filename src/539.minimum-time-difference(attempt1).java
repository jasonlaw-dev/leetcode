import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=539 lang=java
 *
 * [539] Minimum Time Difference
 */

// @lc code=start
class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<>();
        for (String time : timePoints) {
            times.add(timeToMinutes(time));
        }
        Collections.sort(times);
        int min = Integer.MAX_VALUE;
        int prev = times.get(times.size() - 1) - 24 * 60;
        for (int curr : times) {
            min = Math.min(min, curr - prev);
            prev = curr;
        }
        return min;
    }
    private int timeToMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3));
        return hours * 60 + minutes;
    }
}
// @lc code=end

