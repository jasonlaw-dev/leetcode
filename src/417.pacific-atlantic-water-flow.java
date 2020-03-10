import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {

    int m;
    int n;

    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, pacific, Integer.MIN_VALUE);
            dfs(matrix, i, n - 1, atlantic, Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, pacific, Integer.MIN_VALUE);
            dfs(matrix, m - 1, j, atlantic, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] matrix, int i, int j, boolean[][] visited, int prev) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || matrix[i][j] < prev) {
            return;
        }
        visited[i][j] = true;
        for(int[]d:dirs){
            dfs(matrix, i + d[0], j + d[1], visited, matrix[i][j]);
        }
    }
}
// @lc code=end

