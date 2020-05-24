import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            expand(s, dp, i, i);
            if (i + 1 < s.length()) {
                expand(s, dp, i, i + 1);
            }
        }
        bt(s, dp, 0, res, new LinkedList<>());
        return res;
    }
    public void expand(String s, boolean[][] dp, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            dp[left][right] = true;
            left--;
            right++;
        }
    }
    public void bt(String s, boolean[][] dp, int start, List<List<String>> res, LinkedList<String> curr) {
        if (start == s.length()) {
            res.add(new ArrayList<>(curr));
        }
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                String word = s.substring(start, end + 1);
                curr.add(word);
                bt(s, dp, end + 1, res, curr);
                curr.removeLast();
            }
        }
    }
}
// @lc code=end

