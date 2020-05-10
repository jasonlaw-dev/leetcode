import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=524 lang=java
 *
 * [524] Longest Word in Dictionary through Deleting
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        char[] sc = s.toCharArray();
        for (String w : d) {
            char[] wc = w.toCharArray();
            int i = 0;
            int j = 0;
            while (i < sc.length && j < wc.length) {
                if (sc[i] == wc[j]) {
                    j++;
                }
                i++;
            }
            if (j == wc.length && (wc.length > res.length() || wc.length == res.length() && w.compareTo(res) < 0)) {
                res = w;
            }
        }
        return res;
    }
}
// @lc code=end

