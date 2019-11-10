import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

/*
[0] = { "" }
[1] = { "()" }
[2] = { "(())", "()()" }
*/

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        bt(results, "", 0, 0, n);
        return results;
    }

    public void bt(List<String> results, String s, int open, int close, int n) {
        if (s.length() == n * 2) {
            results.add(s);
        } else {
            if (open < n) {
                bt(results, s + "(", open + 1, close, n);
            }
            if (close < open) {
                bt(results, s + ")", open, close + 1, n);
            }
        }
    }
}
// @lc code=end

