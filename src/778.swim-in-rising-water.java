import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=778 lang=java
 *
 * [778] Swim in Rising Water
 */

// @lc code=start
class Solution {
    int[][] dirs = new int[][]{{1,0},{-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        boolean[][] visited = new boolean[N][N];
        pq.add(new int[]{0,0});
        visited[0][0] = true;
        int t = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            t = Math.max(t, grid[i][j]);
            if (i == N - 1 && j == N - 1) return t;
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && y >= 0 && x < N && y < N && !visited[x][y]) {
                    visited[x][y] = true;
                    pq.add(new int[]{x,y});
                }
            }
        }
        return -1;
    }
}
// @lc code=end

