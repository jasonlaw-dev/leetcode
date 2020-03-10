import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        visit("JFK", res, map);
        return res;
    }

    public void visit(String from, LinkedList<String> res, Map<String, PriorityQueue<String>> map) {
        if (map.containsKey(from)) {
            while (!map.get(from).isEmpty()) {
                visit(map.get(from).poll(), res, map);
            }
        }
        res.addFirst(from);
    }
}
// @lc code=end

