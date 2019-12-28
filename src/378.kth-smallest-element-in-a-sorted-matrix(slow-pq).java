import java.util.Collection;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                pq.add(matrix[i][j]);
            }
        }
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.poll();
    }
}
// @lc code=end

