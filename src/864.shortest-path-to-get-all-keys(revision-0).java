import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode id=864 lang=java
 *
 * [864] Shortest Path to Get All Keys
 */

// @lc code=start
class Solution {
    int[][] dirs = {{0,1},{0, -1},{1,0},{-1,0}};
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int target = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[m][n][1 << 6];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j][0] = true;
                } else if (c >= 'a' && c <= 'z') {
                    target = addKey(target, c);
                }
            }
        }
        int steps = 0;
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int i = curr[0] + dir[0];
                    int j = curr[1] + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        char c = grid[i].charAt(j);
                        int bits = curr[2];
                        if (c == '#' || c >= 'A' && c <= 'F' && !hasKey(bits, c)) {
                            continue;
                        }
                        if (c >= 'a' && c <= 'f') {
                            bits = addKey(bits, c);
                            if (bits == target) {
                                return steps + 1;
                            }
                        }
                        if (!visited[i][j][bits]) {
                            visited[i][j][bits] = true;
                            queue.add(new int[]{i, j, bits});
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private int addKey(int bits, char key) {
        return bits | (1 << (key - 'a'));
    }
    private boolean hasKey(int bits, char key) {
        return (bits & (1 << (key - 'A'))) > 0;
    }
}
// @lc code=end

