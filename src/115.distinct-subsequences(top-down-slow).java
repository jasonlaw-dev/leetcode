import java.util.Arrays;

/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) return 0;
        int[][] memo = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return bt(s, t, 0, 0, memo);
    }

    public int bt(String s, String t, int i, int j, int[][] memo) {
        if (j == t.length()) {
            return 1;
        }
        if (s.length() - i < t.length() - j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        memo[i][j] = bt(s, t, i + 1, j, memo);
        if (s.charAt(i) == t.charAt(j)) {
            memo[i][j] += bt(s, t, i + 1, j + 1, memo);
        }
        return memo[i][j];
    }
}
// @lc code=end

