import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<List<String>> buckets = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        for (String word : words) {
            int freq = freqMap.getOrDefault(word, 0);
            freqMap.put(word, freq + 1);
            maxFreq = Math.max(maxFreq, freq + 1);
        }
        for (int i = 0; i <= maxFreq; i++) {
            buckets.add(new ArrayList<>());
        }
        for (String word : freqMap.keySet()) {
            buckets.get(freqMap.get(word)).add(word);
        }
        List<String> res = new ArrayList<>();
        for (int i = buckets.size() - 1; i >= 0 && k > 0; i--) {
            List<String> wordList = buckets.get(i);
            Collections.sort(wordList);
            for (int j = 0; j < wordList.size() && k > 0; j++, k--) {
                res.add(wordList.get(j));
            }
        }
        return res;
    }
}
// @lc code=end

