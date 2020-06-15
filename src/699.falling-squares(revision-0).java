import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=699 lang=java
 *
 * [699] Falling Squares
 */

// @lc code=start
class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> res = new ArrayList<>(n);
        int[] heights = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] pos = positions[i];
            int bottom = 0;
            for (int j = 0; j < i; j++) {
                int[] other = positions[j];
                if (pos[0] < other[0] + other[1] && pos[0] + pos[1] > positions[j][0]) {
                    bottom = Math.max(bottom, heights[j]);
                }
            }
            heights[i] = bottom + pos[1];
            max = Math.max(heights[i], max);
            res.add(max);
        }
        return res;
    }
}
// @lc code=end

