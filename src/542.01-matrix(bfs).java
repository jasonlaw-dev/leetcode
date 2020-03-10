import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new int[] {i, j});
                }
            }
        }

        int distance = 1;
        while (!queue.isEmpty()) {
            for (int size = queue.size() - 1; size >= 0; size--) {
                int[] pair = queue.poll();
                for (int[] dir : directions) {
                    int i = pair[0] + dir[0];
                    int j = pair[1] + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                        visited[i][j] = true;
                        res[i][j] = distance;
                        queue.add(new int[]{i, j});
                    }
                }
            }
            distance++;
        }
        return res;
    }
    int[][] directions = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
}
// @lc code=end

