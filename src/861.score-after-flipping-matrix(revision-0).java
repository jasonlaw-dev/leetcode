/*
 * @lc app=leetcode id=861 lang=java
 *
 * [861] Score After Flipping Matrix
 * 0 0 1 1
 * 1 0 1 0
 * 1 1 0 0
 * 
 * 1 1 0 0
 * 1 0 1 0
 * 1 1 0 0
 * 
 * 0 0 1 1
 * 0 1 0 1
 * 0 0 1 1
 */

// @lc code=start
class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int res = 0;
        for (int j = 0; j < n; j++) {
            int mul = 1 << (n - j - 1);
            if (j == 0) {
                res += mul * m;
            } else {
                int count = 0;
                for (int i = 0; i < m; i++) {
                    count += A[i][j] ^ A[i][0];
                }
                res += mul * Math.max(count, m - count);
            }
        }
        return res;
    }
}
// @lc code=end

