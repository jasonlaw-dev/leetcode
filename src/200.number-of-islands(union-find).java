/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    int count = 0;
    int m;
    int n;
    int[][] dirs = {{0,1},{1,0}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int[] parent = new int[m*n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    int idx = i * n + j;
                    parent[idx] = idx;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < m && y < n && grid[x][y] == '1') {
                            union(parent, i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        return count;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    private void union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);
        if (x != y) {
            parent[x] = y;
            count--;
        }
    }
}
// @lc code=end

