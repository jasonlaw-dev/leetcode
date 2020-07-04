import java.util.Arrays;

/*
 * @lc app=leetcode id=956 lang=java
 *
 * [956] Tallest Billboard
 */

// @lc code=start
class Solution {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        int[] dp = new int[sum * 2 + 1];
        Arrays.fill(dp, -1);
        dp[sum] = 0;
        for (int rod : rods) {
            int[] next = new int[sum * 2 + 1];
            Arrays.fill(next, -1);
            for (int i = 0; i < dp.length; i++) {
                if (i - rod >= 0 && dp[i - rod] >= 0) {
                    next[i] = Math.max(next[i], dp[i - rod] + rod);
                }
                if (i + rod <= sum * 2 && dp[i + rod] >= 0) {
                    next[i] = Math.max(next[i], dp[i + rod]);
                }
                if (dp[i] >= 0) {
                    next[i] = Math.max(next[i], dp[i]);
                }
            }
            dp = next;
        }
        return dp[sum];
    }
}
// @lc code=end

