import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        if (words.length != 0) {
            Map<String, int[]> map = new HashMap<>();
            for (String word : words) {
                if (!map.containsKey(word)) {
                    map.put(word, new int[2]);
                }
                map.get(word)[0]++;
            }

            int wordSize = words[0].length();
            for (int startIndex = 0; startIndex < wordSize; startIndex++) {
                int i = startIndex;
                int j = startIndex;
                int matchCount = 0;
                while (i <= s.length() - words.length * wordSize) {
                    int[] pair = map.get(s.substring(j, j + wordSize));
                    if (pair == null) {
                        matchCount = 0;
                        resetMap(map);
                        i = j + wordSize;
                    } else {
                        matchCount++;
                        pair[1]++;
                        if (pair[1] > pair[0]) {
                            while (i < j && pair[1] != pair[0]) {
                                map.get(s.substring(i, i + wordSize))[1]--;
                                matchCount--;
                                i += wordSize;
                            }
                        }
                        if (matchCount == words.length) {
                            results.add(i);
                            map.get(s.substring(i, i + wordSize))[1]--;
                            matchCount--;
                            i += wordSize;
                        }
                    }
                    j += wordSize;
                }
                resetMap(map);
            }
        }
        return results;
    }

    public void resetMap(Map<String, int[]> map) {
        for (int[] pair : map.values()) {
            pair[1] = 0;
        }
    }
}
// @lc code=end

