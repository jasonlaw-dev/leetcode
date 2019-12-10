/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, i, j, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int i, int j, boolean[][] visited, int k) {

        if (!visited[i][j] && word.charAt(k) == board[i][j]) {
            if (k == word.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            if (
                j > 0 && exist(board, word, i, j - 1, visited, k + 1)
                || j < board[0].length - 1 && exist(board, word, i, j + 1, visited, k + 1)
                || i > 0 && exist(board, word, i - 1, j, visited, k + 1)
                || i < board.length - 1 && exist(board, word, i + 1, j, visited, k + 1)
            ) {
                return true;
            }
            visited[i][j] = false;
        }
        return false;
    }
}
// @lc code=end

