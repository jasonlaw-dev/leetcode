import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        boolean found = false;
        for (String word : wordList) {
            if (!found && word.equals(endWord)) {
                found = true;
            }
            for (String key : getKeys(word)) {
                map.putIfAbsent(key, new HashSet<>());
                map.get(key).add(word);
            }
        }
        if (!found) {
            return results;
        }
        if (beginWord.equals(endWord)) {
            results.add(Arrays.asList(beginWord));
            return results;
        }
        found = false;
        Set<String> visited = new HashSet<>();
        Deque<List<String>> queue = new ArrayDeque<>();
        queue.add(Arrays.asList(beginWord));
        visited.add(beginWord);
        while (!queue.isEmpty() && !found) {
            Set<String> visitedToAdd = new HashSet<>();
            for (int size = queue.size(); size > 0; size--) {
                List<String> currList = queue.poll();
                String prevWord = currList.get(currList.size() - 1);
                for (String key : getKeys(prevWord)) {
                    if (map.containsKey(key)) {
                        for (String nextWord : map.get(key)) {
                            if (nextWord.equals(endWord)) {
                                found = true;
                                List<String> nextList = new ArrayList<>(currList);
                                nextList.add(nextWord);
                                results.add(nextList);
                            } else if (!found && !visited.contains(nextWord)) {
                                visitedToAdd.add(nextWord);
                                List<String> nextList = new ArrayList<>(currList);
                                nextList.add(nextWord);
                                queue.add(nextList);
                            }
                        }
                    }
                    
                }
            }
            visited.addAll(visitedToAdd);
        }
        return results;
    }

    private List<String> getKeys(String word) {
        List<String> keys = new ArrayList<>();
        char[] c = word.toCharArray();
        for (int i = 0; i < c.length; i++) {
            char temp = c[i];
            c[i] = '*';
            keys.add(new String(c));
            c[i] = temp;
        }
        return keys;
    }
}
// @lc code=end

