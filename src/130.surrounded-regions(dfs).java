import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1,0}};
    public void solve(char[][] board) {
        if (board.length <= 1 || board[0].length <= 1) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows-1, j);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(char[][] board, int i, int j) {
        board[i][j] = '*';
        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
            dfs(board, i-1,j);
        }
        if (j - 1 >= 0 && board[i][j-1] == 'O') {
            dfs(board, i, j - 1);
        }
        if (i + 1 < board.length && board[i + 1][j] == 'O') {
            dfs(board, i+1,j);
        }
        if (j + 1 < board[0].length && board[i][j+1] == 'O') {
            dfs(board, i, j + 1);
        }
    }
}
// @lc code=end

