import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 * 
 *  NOTE: Good thing about dfs is that, at each level, the subtree will be the same
 */

// @lc code=start
class Solution {
    static String[] digitMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        return dfs(digits, 0);
    }

    public List<String> dfs(String digits, int index) {
        List<String> results = new ArrayList<>();
        if (digits.length() == index) {
            results.add("");
        } else {
            List<String> subtree = dfs(digits, index + 1);
            for (char c : digitMap[digits.charAt(index) - '2'].toCharArray()) {
                for (String tail : subtree) {
                    results.add(c + tail);
                }
            }
        }
        return results;
    }
}
// @lc code=end

