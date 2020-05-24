import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int i = 0;
        for (i = 0; i < strs[0].length(); i++) {
            boolean shouldBreak = false;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    shouldBreak = true;
                    break;
                }
            }
            if (shouldBreak) break;
        }
        return strs[0].substring(0, i);
    }
}
// @lc code=end

