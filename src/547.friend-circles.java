/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M, j, visited);
            }
        }
    }
}
// @lc code=end

