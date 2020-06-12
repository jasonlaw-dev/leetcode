/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 */

 // DP
 // new int[w1.length + 1][w2.length + 1]
 // for each i,j  compare w1[i] w2[j], if equal, dp[i+1][j+1] = 1 + dp[i][j]
 // if not equal math.max(dp[i+1][j], dp[j][i+1])

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int[] dpPrev = new int[word2.length() + 1];
        int[] dpCurr = new int[word2.length() + 1];
        int max = 0;
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dpCurr[j+1] = 1 + dpPrev[j];
                    max = Math.max(max, dpCurr[j+1]);
                } else {
                    dpCurr[j+1] = Math.max(dpCurr[j], dpPrev[j+1]);
                }
            }
            dpPrev = dpCurr;
            dpCurr = new int[word2.length() + 1];
        }
        return word1.length() + word2.length() - max * 2;
    }
}
// @lc code=end

