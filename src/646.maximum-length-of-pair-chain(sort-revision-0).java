import java.util.Arrays;

/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int len = 0;
        int prev = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > prev) {
                len++;
                prev = pair[1];
            }
        }
        return len;
    }
}
// @lc code=end

