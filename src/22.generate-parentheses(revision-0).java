import java.util.ArrayList;
import java.util.List;

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
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<String> results = new ArrayList<>();
            if (i == 0) {
                results.add("");
            } else {
                for (int j = 0; j < i; j++) {
                    for (String s1 : list.get(j)) {
                        for (String s2: list.get(i - j - 1)) {
                            results.add("(" + s1 + ")" + s2);
                        }
                    }
                }
            }
            list.add(results);
        }
        return list.get(n);
    }
}
// @lc code=end

