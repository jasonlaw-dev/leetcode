// import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
import java.util.AbstractMap;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        boolean found = false;
        for (String word : wordList) {
            if (!found && word.equals(endWord)) {
                found = true;
            }
            for (int i = 0; i < word.length(); i++) {
                String transformed = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                if (!map.containsKey(transformed)) {
                    map.put(transformed, new ArrayList<>());
                }
                map.get(transformed).add(word);
            }
        }
        if (!found) {
            return 0;
        }

        Queue<Map.Entry<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new AbstractMap.SimpleEntry<>(beginWord, 1));
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            Map.Entry<String, Integer> entry = queue.poll();
            String word = entry.getKey();
            int level = entry.getValue();
            for (int i = 0; i < word.length(); i++) {
                String transformed = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                if (!map.containsKey(transformed)) {
                    continue;
                }
                for (String related : map.get(transformed)) {
                    if (related.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(related)) {
                        queue.add(new AbstractMap.SimpleEntry<>(related, level + 1));
                        visited.add(related);
                    }
                }
            }
        }
        return 0;
    }
}
// @lc code=end

