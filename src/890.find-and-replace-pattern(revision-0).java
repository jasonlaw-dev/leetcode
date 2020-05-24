import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=890 lang=java
 *
 * [890] Find and Replace Pattern
 */

// @lc code=start
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int i = 0;
            Map<Character, Character> map = new HashMap<>();
            Set<Character> used = new HashSet<>();
            for (; i < pattern.length(); i++) {
                char w = word.charAt(i);
                char p = pattern.charAt(i);
                Character expected = map.get(p);
                if (expected != null) {
                    if (w != expected) {
                        break;
                    }
                } else {
                    if (used.contains(w)) {
                        break;
                    }
                    map.put(p, w);
                    used.add(w);
                }
            }
            if (i == pattern.length()) {
                res.add(word);
            }
        }
        return res;
    }
}
// @lc code=end

