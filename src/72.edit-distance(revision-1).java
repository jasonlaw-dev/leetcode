/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 * dp[i+1][j+1] = min operations for word1[0, i] to word2[0, j]
 * first check whether word[i] == word[j], if yes -> dp[i][j]
 * 
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = 1 + Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
// @lc code=end

