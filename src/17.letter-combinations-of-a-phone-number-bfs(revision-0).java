import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        LinkedList<String> results = new LinkedList<>();
        results.add("");
        for (int i = 0; i < digits.length(); i++) {
            while (results.peek().length() == i) {
                String prefix = results.remove();
                for (char c : digitMap[digits.charAt(i) - '2'].toCharArray()) {
                    results.add(prefix + c);
                }
            }
        }
        return results;
    }
}
// @lc code=end

