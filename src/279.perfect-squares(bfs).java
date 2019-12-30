import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        if (n == 0 || n == 1) return 1;
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (; size > 0; size--) {
                int i = queue.poll();
                for (int k = 1; i + k * k <= n; k++) {
                    int sum = i + k * k;
                    if (sum == n) {
                        return level + 1;
                    } else if (!visited[sum]) {
                        queue.offer(sum);
                        visited[sum] = true;
                    }
                }
            }
            level++;
        }
        return 0;
    }

}
// @lc code=end

