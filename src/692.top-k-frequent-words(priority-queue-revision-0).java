import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            int freq = freqMap.getOrDefault(word, 0);
            freqMap.put(word, freq + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int cntA = freqMap.get(a);
            int cntB = freqMap.get(b);
            if (cntA == cntB) {
                return b.compareTo(a);
            }
            return cntA - cntB;
        });
        for (String word : freqMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) pq.poll();
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) res.add(pq.poll());
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

