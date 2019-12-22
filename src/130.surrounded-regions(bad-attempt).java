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
        if (board.length >= 2 && board[0].length != 2) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 1; i < board.length - 1; i++) {
                for (int j = 1; j < board[0].length - 1; j++) {
                    if (board[i][j] == 'O' && !visited[i][j]) {
                        List<int[]> surroundings = new ArrayList<>();
                        if (isEnclosed(board, visited, surroundings, i, j)) {
                            for (int[] xy : surroundings) {
                                board[xy[0]][xy[1]] = 'X';
                            }
                        }
                    }
                }
            }
        }
    
    }

    boolean isEnclosed(char[][] board, boolean[][] visited, List<int[]> surroundings, int i, int j) {
        if (board[i][j] == 'X') {
            return true;
        }
        visited[i][j] = true;
        if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
            return false;
        }
        surroundings.add(new int[]{i, j});
        boolean enclosed = true;
        for (int[] direction : directions) {
            int nextI = i + direction[0];
            int nextJ = j + direction[1];
            if (nextI >= 0 && nextI < board.length && nextJ >=0 && nextJ < board[0].length && !visited[nextI][nextJ]) {
                enclosed = isEnclosed(board, visited, surroundings, nextI, nextJ) && enclosed;
            }
        }
        return enclosed;
    }
}
// @lc code=end

