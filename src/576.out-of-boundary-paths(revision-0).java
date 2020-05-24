/*
 * @lc app=leetcode id=576 lang=java
 *
 * [576] Out of Boundary Paths
 */

// @lc code=start
class Solution {
    
    int[][] dirs = {{0,1}, {0, -1},{1,0},{-1,0}};
    public int findPaths(int m, int n, int N, int ballI, int ballJ) {
        int[][] curr = new int[m][n]; // curr[i][j] = number of paths to reach here.
        int[][] next = new int[m][n];
        int[][] temp;
        int div = 1000000007;
        long res = 0;
        curr[ballI][ballJ] = 1;
        for (; N > 0; N--) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    long sum = 0;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            sum += curr[x][y];
                        } else {
                            res += curr[i][j];
                        }
                    }
                    next[i][j] = (int) (sum % div);
                }
            }
            temp = curr;
            curr = next;
            next = temp;
        }
        return (int) (res % div);
        // 1\n3\n3\n0\n1
    }
}
// @lc code=end

