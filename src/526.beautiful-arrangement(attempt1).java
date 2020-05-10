/*
 * @lc app=leetcode id=526 lang=java
 *
 * [526] Beautiful Arrangement
 */

// @lc code=start
class Solution {
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        return bt(1, N, visited);
    }

    private int bt(int i, int N, boolean[] visited) {
        if (i == N + 1) {
            return 1;
        }
        int sum = 0;
        for (int j = 1; j <= N; j++) {
            if (!visited[j] && (j % i == 0 || i % j == 0)) {
                visited[j] = true;
                sum += bt(i + 1, N, visited);
                visited[j] = false;
            }
        }
        return sum;
    }

}
// @lc code=end

