import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=407 lang=java
 *
 * [407] Trapping Rain Water II
 */

// @lc code=start
class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> heightMap[a[0]][a[1]] - heightMap[b[0]][b[1]]);
        boolean[][] visited = new boolean[m][n];
        int maxHeight = 0;
        int res = 0;
        for (int i = 0; i < m; i++) {
            heap.add(new int[]{i, 0});
            heap.add(new int[]{i, n - 1});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            heap.add(new int[]{0, j});
            heap.add(new int[]{m - 1, j});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int i = curr[0];
            int j = curr[1];
            visited[i][j] = true;
            int currHeight = heightMap[i][j];
            if (currHeight > maxHeight) {
                maxHeight = currHeight;
            } else if (currHeight < maxHeight) {
                res += maxHeight - currHeight;
            }
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    heap.add(new int[]{x, y});
                } 
            }
        }
        return res;
    }
}
// @lc code=end

