/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

 /*
[
  [15,13, 2, 5, 1],
  [15,13, 2, 5, 1],
  [14, 3, 4, 1, 1],
  [12, 6, 8, 9, 1],
  [16, 7,10,11, 1]
]
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int squares = matrix.length / 2;
        for (int sq = 0; sq < squares; sq++) {
            for (int i = 0; i < matrix.length - sq * 2 - 1; i++) {
                int temp = matrix[sq][sq + i];
                matrix[sq][sq + i] = matrix[matrix.length - 1 - sq - i][sq];
                matrix[matrix.length - 1 - sq - i][sq] = matrix[matrix.length - 1 - sq][matrix.length - 1 - sq - i];
                matrix[matrix.length - 1 - sq][matrix.length - 1 - sq - i] = matrix[sq + i][matrix.length - 1 - sq];
                matrix[sq + i][matrix.length - 1 - sq] = temp;
            }
        }
    }
}
// @lc code=end

