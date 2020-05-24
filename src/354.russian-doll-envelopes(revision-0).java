import java.util.Arrays;

/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int lo = 0;
            int hi = len - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (dp[mid] < height) {
                    lo = mid + 1;
                } else if (dp[mid] > height) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                    break;
                }
            }
            dp[lo] = height;
            if (lo == len) {
                len++;
            }
        }
        return len;
    }
}
// @lc code=end

