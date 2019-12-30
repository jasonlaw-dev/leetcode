import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        boolean leftToRight = true;
        int i = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        Deque<int[]> queue = new ArrayDeque<>(Math.max(m, n));
        int[] res = new int[m*n];
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] loc = null;
            for (int size = queue.size(); size > 0; size--) {
                if (leftToRight) {
                    loc = queue.pollFirst();
                    if (loc[0] + 1 < m) {
                        queue.offerLast(new int[] {loc[0] + 1, loc[1]});
                    } 
                } else {
                    loc = queue.pollLast();
                    if (loc[1] + 1 < n) {
                        queue.offerFirst(new int[] {loc[0], loc[1] + 1});
                    }
                }
                res[i] = matrix[loc[0]][loc[1]];
                i++;
            }
            if (leftToRight && loc[1] + 1 < n) {
                queue.offerLast(new int[] {loc[0], loc[1] + 1});
            } else if (!leftToRight && loc[0] + 1 < m) {
                queue.offerFirst(new int[] {loc[0] + 1, loc[1]});
            } 
            leftToRight = !leftToRight;
        }
        return res;
    }
}
// @lc code=end

