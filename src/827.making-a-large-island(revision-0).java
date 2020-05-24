import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=827 lang=java
 *
 * [827] Making A Large Island
 */

// @lc code=start
class Solution {
    int[] parent;
    int[] size;
    int res = 1;
    int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m*n];
        Arrays.fill(parent, -1);
        size = new int[m*n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    parent[i * n + j] = i * n + j;
                    size[i * n + j] = 1;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        union(i * n + j, (i - 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        union(i * n + j, i * n + j - 1);
                    }
                }
            }
        }
        Set<Integer> parentSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int count = 1;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                            int par = find(x * n + y);
                            if (parentSet.add(par)) {
                                count += size[par];
                            }
                        }
                    }
                    res = Math.max(count, res);
                    parentSet.clear();
                }
            }
        }
        return res;
    }
    private void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            parent[y] = x;
            size[x] = size[x] + size[y];
            res = Math.max(res, size[x]);
        }
    }
    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
}
// @lc code=end

