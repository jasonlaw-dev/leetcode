import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=1014 lang=java
 *
 * [1014] Best Sightseeing Pair
 */

// @lc code=start
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int maxSpot = A[0];
        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, maxSpot + A[i] - i);
            maxSpot = Math.max(maxSpot, A[i] + i);
        }
        return res;
    }
}
// @lc code=end

