import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n < 1) {
            return results;
        }
        int[][] board = new int[n][n];
        solve(board, 0, results);
        return results;
    }
    public void solve(int[][] board, int row, List<List<String>> results) {
        if (row == board.length) {
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                char[] line = new char[board.length];
                for (int j = 0; j < board.length; j++) {
                    line[j] = board[i][j] == -1 ? 'Q' : '.';
                }
                tempList.add(new String(line));
            }
            results.add(tempList);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (board[row][col] == 0) {
                fill(board, row, col, 1);
                board[row][col] = -1;
                solve(board, row + 1, results);
                fill(board, row, col, -1);
                board[row][col] = 0;
            }
        }
    }
    // List<String> boardToResult = new ArrayList<>();

    public void fill(int[][] board, int row, int col, int add) {
        for (int i = row; i < board.length; i++) {
            board[i][col] += add;
        }
        for (int i = row, j = col; i < board.length && j < board.length; i++, j++) {
            board[i][j] += add;
        }
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            board[i][j] += add;
        }
    }
}
// @lc code=end

