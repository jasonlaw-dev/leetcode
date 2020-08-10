import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean found = false;
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            if (word.equals(endWord)) {
                found = true;
            }
            for (String comb : getCombinations(word)) {
                if (!map.containsKey(comb)) {
                    map.put(comb, new ArrayList<>());
                }
                map.get(comb).add(word);
            }
        }
        if (!found) {
            return 0;
        }
        Set<String> seen = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        seen.add(beginWord);
        int res = 1;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                for (String comb : getCombinations(curr)) {
                    if (map.containsKey(comb)) {
                        for (String next : map.get(comb)) {
                            if (seen.contains(next)) {
                                continue;
                            }
                            seen.add(next);
                            if (next.equals(endWord)) {
                                return res;
                            }
                            q.add(next);
                        }
                    }
                }
            }
        }
        return 0;
    }
    private List<String> getCombinations(String word) {
        List<String> list = new ArrayList<>();
        char[] str = word.toCharArray();
        for (int i = 0; i < str.length; i++) {
            char temp = str[i];
            str[i] = '*';
            list.add(new String(str));
            str[i] = temp;
        }
        return list;
    }
}
// @lc code=end

