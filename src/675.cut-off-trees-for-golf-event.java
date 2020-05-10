import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=675 lang=java
 *
 * [675] Cut Off Trees for Golf Event
 */

// @lc code=start
class Solution {
    int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]);
        });
        int M = forest.size();
        int N = forest.get(0).size();
        for (int i = 0; i < M; i++) {
            List<Integer> row = forest.get(i);
            for (int j = 0; j < N; j++) {
                if (row.get(j) > 1) {
                    pq.add(new int[] {i, j});
                }
            }
        }
        int res = 0;

        int[] from = new int[]{0,0};
        while (!pq.isEmpty()) {
            int[] to = pq.poll();
            int steps = bfs(forest, from, to, M, N);
            if (steps == -1) return -1;
            res += steps;
            from = to;
        }
        return res;
    }
    private int bfs(List<List<Integer>> forest, int[] from, int[] to, int M, int N) {
        int steps = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[M][N];
        queue.offer(from);
        visited[from[0]][from[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] next = queue.poll();
                if (next[0] == to[0] && next[1] == to[1]) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int x = next[0] + dir[0];
                    int y = next[1] + dir[1];
                    if (x >= 0 && x < M && y >= 0 && y < N && !visited[x][y] && forest.get(x).get(y) >= 1) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            steps++;
        }
        return - 1;
    }
}
// @lc code=end

