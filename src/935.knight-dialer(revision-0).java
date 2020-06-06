import java.util.Arrays;

/*
 * @lc app=leetcode id=935 lang=java
 *
 * [935] Knight Dialer
 */

// @lc code=start
// 6 + 3 + 1 + 3 + 2 + 2 + 2 + 2
class Solution {
    public int knightDialer(int N) {
        int mod = 1000000007;
        int[][] moves = {
            {4,6},
            {6,8},
            {7,9},
            {4,8},
            {0,3,9},
            {},
            {0,1,7},
            {2,6},
            {1,3},
            {2,4}
        };
        long[] dp = new long[10];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= N; i++) {
            long[] next = new long[10];
            for (int j = 0; j < moves.length; j++) {
                dp[j] %= mod;
                for (int k : moves[j]) {
                    next[k] += dp[j];
                }
            }
            dp = next;
        }
        long sum = 0;
        for (long num : dp) {
            sum += num % mod;
        }
        return (int) (sum % mod);
    }
}
// @lc code=end

