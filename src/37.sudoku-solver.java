import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    boolean[][] rows = new boolean[9][];
    boolean[][] cols = new boolean[9][];
    boolean[][] boxes = new boolean[9][];

    Stack<int[]> stack = new Stack<int[]>();

    private boolean[][] getArrays(int i, int j) {
        return new boolean[][]{rows[i], cols[j], boxes[(i / 3) * 3 + j / 3]};
    }

    private void initialize(char[][] board) {
        for (int i = 0; i < 9; i++) {
            rows[i] = new boolean[9];
            cols[i] = new boolean[9];
            boxes[i] = new boolean[9];
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '1';
                    for (boolean[] array : getArrays(i, j)) {
                        array[num] = true;
                    }
                }
            }
        }
    }

    public void solveSudoku(char[][] board) {
        initialize(board);
        bt(board);
    }

    public boolean bt(char[][] board) {
        if (!stack.isEmpty()) {
            int[] pair = stack.pop();
            boolean[][] arrays = getArrays(pair[0], pair[1]);
            for (int num = 0; num < 9; num++) {
                if (!arrays[0][num] && !arrays[1][num] && !arrays[2][num]) {
                    if (stack.size() == 0) {
                        System.out.println(num + " " + pair[0] + " " + pair[1]);
                    }
                    for (int i = 0; i < arrays.length; i++) {
                        arrays[i][num] = true;
                    }
                    board[pair[0]][pair[1]] = (char) ('1' + num);
                    boolean result = bt(board);
                    if (result) {
                        return true;
                    }
                    board[pair[0]][pair[1]] = '.';
                    for (int i = 0; i < arrays.length; i++) {
                        arrays[i][num] = false;
                    }
                }
            }
            stack.push(pair);
            return false;
        }
        return true;
    }
}
// @lc code=end

