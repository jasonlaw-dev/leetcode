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
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return results;
        }

        Deque<List<String>> queue = new ArrayDeque<>();
        queue.add(Arrays.asList(beginWord));
        set.remove(beginWord);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            Set<String> visitedToAdd = new HashSet<>();
            for (int size = queue.size(); size > 0; size--) {
                List<String> currList = queue.poll();
                String prevWord = currList.get(currList.size() - 1);
                if (prevWord.equals(endWord)) {
                    found = true;
                    results.add(currList);
                } else if (!found) {
                    char[] charArray = prevWord.toCharArray();
                    for (int i = 0; i < charArray.length; i++) {
                        char original = charArray[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == original) {
                                continue;
                            }
                            charArray[i] = c;
                            String nextWord = new String(charArray);
                            if (set.contains(nextWord)) {
                                visitedToAdd.add(nextWord);
                                List<String> nextList = new ArrayList<>(currList);
                                nextList.add(nextWord);
                                queue.add(nextList);
                            }
                        }
                        charArray[i] = original;
                    }
                }
            }
            for (String visited: visitedToAdd) {
                set.remove(visited);
            }
        }
        return results;
    }
}
// @lc code=end

