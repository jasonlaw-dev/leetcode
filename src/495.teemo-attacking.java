/*
 * @lc app=leetcode id=495 lang=java
 *
 * [495] Teemo Attacking
 */

// @lc code=start
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            int nextStart = i == timeSeries.length - 1 ? timeSeries[i] + duration : timeSeries[i + 1];
            count += Math.min(nextStart - timeSeries[i], duration);
        }
        return count;
    }
}
// @lc code=end

