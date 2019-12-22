import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            boolean isFound = false;
            for (int j = i; j >= 0 && !isFound; j--) {
                if (j == i) {
                    isFound = words.contains(s.substring(0, i + 1));
                } else {
                    isFound = dp[j] && words.contains(s.substring(j + 1, i + 1));
                }
            }
            dp[i] = isFound;
        }
        return dp[s.length() - 1];
    }
}
// @lc code=end

