import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int wrong = check(s);
        dfs(s, wrong, new HashSet<>(), res);
        return res;
    }
    public void dfs(String s, int wrong, Set<String> visited, List<String> res) {
        if (visited.contains(s)) {
            return;
        }
        visited.add(s);
        int wrongCount = check(s);
        if (wrongCount == 0) {
            res.add(s);
            return;
        }
        if (wrongCount != wrong) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1, s.length()), wrongCount - 1, visited, res);
            }
        }
    }
    private int check(String s) {
        int open = 0;
        int wrongCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                } else {
                    wrongCount++;
                }
            }
        }
        return open + wrongCount;
    }
}
// @lc code=end

