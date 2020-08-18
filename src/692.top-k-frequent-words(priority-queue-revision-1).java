import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((e1, e2) -> e1.getValue() == e2.getValue() ? e2.getKey().compareTo(e1.getKey()) :e1.getValue() - e2.getValue());
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        LinkedList<String> res = new LinkedList<>();
        while (queue.size() > 0) {
            res.addFirst(queue.poll().getKey());
        }
        return res;
    }
}
// @lc code=end

