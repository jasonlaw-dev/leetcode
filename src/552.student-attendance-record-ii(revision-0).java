/*
 * @lc app=leetcode id=552 lang=java
 *
 * [552] Student Attendance Record II
 * 
 * states:
 * ends with 1 L (with / without 1A)
 * doesn't end with L (with / without 1A)
 * dp[i][ends with 1L bool][with 1A bool]
 * 
 * dp[i][0][0] = dp[i-1][0][0] + dp[i-1][1][0]
 * dp[i][0][1] = dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][1][0] + dp[i-1][1][1]
 * dp[i][1][0] = dp[i-1][0][0]
 * dp[i][1][1] = dp[i-1][0][1]
 * 
 * dp[0][0][0] = 1
 * dp[0][0][1] = 1
 * dp[0][1][0] = 1
 * dp[0][1][1] = 0
 */

// @lc code=start
class Solution {
    long mod = 1000000007;
    public int checkRecord(int n) {
        long[][] curr = new long[][]{{1,1},{1,0},{0, 0}};
        long[][] next = new long[3][2];
        long[][] temp = null;
        
        for (int i = 1; i < n; i++) {
            next[0][0] = (curr[0][0] + curr[1][0] + curr[2][0]) % mod;
            next[0][1] = (curr[0][0] + curr[0][1] + curr[1][0] + curr[1][1] + curr[2][0] + curr[2][1]) % mod;
            next[1][0] = curr[0][0];
            next[1][1] = curr[0][1];
            next[2][0] = curr[1][0];
            next[2][1] = curr[1][1];

            temp = curr;
            curr = next;
            next = temp;

        }
        return (int)((curr[0][0] + curr[0][1] + curr[1][0] + curr[1][1] + curr[2][0] + curr[2][1]) % mod);
    }
}
// @lc code=end

