/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

 // [i, j, k] // after considering string k, i 0s and j 1s
 // space O(m*n*k)

// we only need to know dp[i][j] and dp[i-zeros][j-ones]

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int zeros = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeros++;
            }
            int ones = str.length() - zeros;

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

