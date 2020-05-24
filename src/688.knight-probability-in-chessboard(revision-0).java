/*
 * @lc app=leetcode id=688 lang=java
 *
 * [688] Knight Probability in Chessboard
 */

// @lc code=start
class Solution {

    int[][] moves = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1} };

    public double knightProbability(int N, int K, int r, int c) {
        if (K == 0) return 1;
        double[][] prev = new double[N][N];
        double[][] curr = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                prev[i][j] = 1;
            }
        }

        for (; K > 0; K--) {
            curr = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] move : moves) {
                        int x = i + move[0];
                        int y = j + move[1];
                        if (x >= 0 && x < N && y >= 0 && y < N) {
                            curr[i][j] += prev[x][y] / 8;
                        }
                    }
                }
            }
            printMatrix(curr);
            prev = curr;
        }
        return prev[r][c];
    }
    public void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
// @lc code=end

