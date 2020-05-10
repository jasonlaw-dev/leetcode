import java.util.Arrays;

/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int count = 1;
        int prev = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (prev < points[i][0]) {
                count++;
                prev = points[i][1];
            }
        }
        return count;
    }
}
// @lc code=end

