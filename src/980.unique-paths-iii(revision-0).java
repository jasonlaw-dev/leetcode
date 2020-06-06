/*
 * @lc app=leetcode id=980 lang=java
 *
 * [980] Unique Paths III
 */

// @lc code=start
class Solution {
    int m = 0;
    int n = 0;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int empty = 0;
        int[] start = new int[2];
        int[] end = new int[2];
        start[0] = -1;
        end[0] = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                if (val == 1) {
                    start[0] = i;
                    start[1] = j;
                } else if (val == 2) {
                    end[0] = i;
                    end[1] = j;
                } else if (val == 0) {
                    empty++;
                }
            }
        }
        if (start[0] == -1 || end[0] == -1) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        return count(grid, visited, start[0], start[1], empty);
    }
    private int count(int[][] grid, boolean[][] visited, int i, int j, int empty) {
        if (grid[i][j] == 2) {
            return empty == 0 ? 1 : 0;
        }
        visited[i][j] = true;
        int count = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] != -1) {
                count += count(grid, visited, x, y, empty - (grid[x][y] == 0 ? 1 : 0));
            }
        }
        visited[i][j] = false;
        return count;
    }
}
// @lc code=end

