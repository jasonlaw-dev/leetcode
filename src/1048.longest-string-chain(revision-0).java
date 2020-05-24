import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 */

// @lc code=start
class Solution {
    public int longestStrChain(String[] words) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i <= 16; i++) {
            list.add(new ArrayList<>());
        }
        for (String word : words) {
            list.get(word.length()).add(word);
        }

        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (List<String> subList : list) {
            for (String word : subList) {
                int len = 1;
                for (int i = 0; i < word.length(); i++) {
                    String cand = word.substring(0, i) + word.substring(i + 1, word.length());
                    len = Math.max(len, map.getOrDefault(cand, 0) + 1);
                }
                map.put(word, len);
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
// @lc code=end

