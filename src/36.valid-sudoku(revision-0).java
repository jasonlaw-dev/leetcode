import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char rowValue = board[i][j];
                if (rowValue != '.' && !row.add(rowValue)) {
                    return false;
                }
                char colValue = board[j][i];
                if (colValue != '.' && !col.add(colValue)) {
                    return false;
                }
                int rowStart = (i / 3) * 3;
                int colStart = (i % 3) * 3;
                char boxValue = board[rowStart + (j / 3)][colStart + (j % 3)];
                if (boxValue != '.' && !box.add(boxValue)) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

