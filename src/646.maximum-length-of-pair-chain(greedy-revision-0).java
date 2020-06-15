import java.util.Arrays;

/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 */

/*
can we do better than O(n^2)

*/

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) return 0;
        int res = 1;
        int[] dp = new int[pairs.length];
        Arrays.sort(pairs, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < pairs.length; i++) {
            int[] firstFound = null;
            for (int j = i - 1; j >= 0; j--) {
                if (firstFound != null && pairs[j][1] < firstFound[0]) {
                    break;
                }
                if (pairs[j][1] < pairs[i][0]) {
                    if (firstFound == null) {
                        firstFound = pairs[j];
                    }
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end

