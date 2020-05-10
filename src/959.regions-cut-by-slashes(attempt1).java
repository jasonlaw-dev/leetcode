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
        int[][] visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 3) continue;
                char curr = grid[i].charAt(j);
                if (curr != ' ') {
                    if (visited[i][j] != 1) {
                        count++;
                        dfs(grid, N, i, j, i, j - 1, visited);
                    }
                    if (visited[i][j] != 3) {
                        count++;
                        dfs(grid, N, i, j, i, j + 1, visited);
                    }
                } else {
                    count++;
                    dfs(grid, N, i, j, i, j + 1, visited);
                }
            }
        }
        return count;
    }

    public void dfs(String[] grid, int N, int i, int j, int prevI, int prevJ, int[][] visited) {
        if (i < 0 || i >= N || j < 0 || j >= N) {
            return;
        }
        if (visited[i][j] == 3) return;
        char curr = grid[i].charAt(j);
        boolean top = false;
        boolean bottom = false;
        boolean left = false;
        boolean right = false;
        if (curr == '/') {
            if ((prevI < i || prevJ < j) && visited[i][j] != 1) {
                top = left = true;
                visited[i][j] = visited[i][j] == 0 ? 1 : 3;
            } if ((prevI > i || prevJ > j) && visited[i][j] != 2) {
                bottom = right = true;
                visited[i][j] = visited[i][j] == 0 ? 2 : 3;
            }
        } else if (curr == '\\') {
            if ((prevI > i || prevJ < j) && visited[i][j] != 1) {
                top = right = true;
                visited[i][j] = visited[i][j] == 0 ? 1 : 3;
            } if ((prevI < i || prevJ > j) && visited[i][j] != 2) {
                bottom = left = true;
                visited[i][j] = visited[i][j] == 0 ? 2 : 3;
            }
        } else {
            top = bottom = left = right = true;
            visited[i][j] = 3;
        }
        if (top) dfs(grid, N, i, j - 1, i, j, visited);
        if (bottom) dfs(grid, N, i, j + 1, i, j, visited);
        if (left) dfs(grid, N, i - 1, j, i, j, visited);
        if (right) dfs(grid, N, i + 1, j, i, j, visited);
    }
}
// @lc code=end

