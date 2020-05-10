import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 */

// @lc code=start
class Solution {
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0, -1}};
    public int shortestBridge(int[][] A) {
        boolean found = false;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    found = true;
                    dfs(A, i, j, queue);
                    break;
                }
            }
            if (found) break;
        }
        return bfs(A, queue);
    }
    private void dfs(int[][] A, int i, int j, Queue<int[]> queue) {
        A[i][j] = 2;
        queue.add(new int[] {i, j});
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < A.length && y >= 0 && y < A[0].length && A[x][y] == 1) {
                dfs(A, x, y, queue);
            }
        }
    }
    private int bfs(int[][] A, Queue<int[]> queue) {
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] pos = queue.poll();

                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x >= 0 && x < A.length && y >= 0 && y < A[0].length) {
                        if (A[x][y] == 0) {
                            queue.add(new int[]{x, y});
                            A[x][y] = 2;
                        } else if (A[x][y] == 1) {
                            return count;
                        }
                    }
                }
                
            }
            count++;
        }
        return count;
    }
}
// @lc code=end

