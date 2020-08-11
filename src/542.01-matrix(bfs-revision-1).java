import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[][] { };
        }
        if (matrix[0].length == 0) {
            return new int[matrix.length][0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        // int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                matrix[curr[0]][curr[1]] = dist;
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new int[]{x,y});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}
// @lc code=end

