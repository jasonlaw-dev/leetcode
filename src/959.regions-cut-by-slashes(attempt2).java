/*
 * @lc app=leetcode id=959 lang=java
 *
 * [959] Regions Cut By Slashes
 * 
 * int[][] visited = new int[N][N]
 * // 1 -> top visited, 2-> bottom visited, 3 -> visited both regions
 * main method will iterate thru each cell twice, to cater for cells with slashes
 * 
 */

// @lc code=start
class Solution {

    public int regionsBySlashes(String[] grid) {
        int count = 0;
        int N = grid.length;
        boolean[][] visited = new boolean[3*N][3*N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    visited[3 * i + 2][3 * j] = visited[3 * i + 1][3 * j + 1] = visited[3 * i][3 * j + 2] = true;
                } else if (c == '\\') {
                    visited[3 * i][3 * j] = visited[3 * i + 1][3 * j + 1] = visited[3 * i + 2][3 * j + 2] = true;
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(visited, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(boolean[][] visited, int i, int j) {
        int N = visited.length;
        if (i >= 0 && i < N && j >= 0 && j < N && !visited[i][j]) {
            visited[i][j] = true;
            dfs(visited, i, j + 1);
            dfs(visited, i, j - 1);
            dfs(visited, i + 1, j);
            dfs(visited, i - 1, j);
        }
    }
}
// @lc code=end

