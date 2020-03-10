import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map  = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> charOrder = new ArrayList<>(map.entrySet());
        Collections.sort(charOrder, (a, b) -> b.getValue() - a.getValue());
        char[] str = new char[s.length()];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : charOrder) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int j = 0; j < count; j++) {
                str[i++] = c;
            }
        }
        return new String(str);
    }
}
// @lc code=end

