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
        int[] slots = new int[1440];
        for (String time : timePoints) {
            if (++slots[timeToMinutes(time)] == 2) {
                return 0;
            }
        }
        int first = -1;
        int last = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] > 0) {
                if (first == -1) {
                    first = i;
                } else {
                    res = Math.min(res, i - last);
                    if (res == 1) {
                        return res;
                    }
                }
                last = i;
            }
        }
        res = Math.min(res, first - (last - 1440));
        return res;
    }
    private int timeToMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3));
        return hours * 60 + minutes;
    }
}
// @lc code=end

