import java.util.Arrays;

/*
 * @lc app=leetcode id=903 lang=java
 *
 * [903] Valid Permutations for DI Sequence
 */

// @lc code=start
class Solution {
    public int numPermsDISequence(String S) {
        int n = S.length();
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            int[] next = new int[n + 1];
            if (S.charAt(i) == 'I') {
                int sum = 0;
                for (int j = 0; j < n - i; j++) {
                    sum = (sum + dp[j]) % mod;
                    next[j] = sum;
                }
            } else {
                int sum = 0;
                for (int j = n - i - 1; j >= 0; j--) {
                    sum = (sum + dp[j + 1]) % mod;
                    next[j] = sum;
                }
            }
            dp = next;
        }
        return dp[0];
    }
}
// @lc code=end

