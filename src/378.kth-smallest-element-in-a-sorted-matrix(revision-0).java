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
        int low = matrix[0][0];
        int high = matrix[rows - 1][cols - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int j = cols - 1;
            for (int i = 0; i < rows; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += j+1;
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid; 
            }
        }
        return low; // need to exlain why low valid in the matrix
    }
}
// @lc code=end

