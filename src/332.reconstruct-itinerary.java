import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new ArrayList<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        for (List<String> list : map.values()) {
            Collections.sort(list);
        }
        res.add("JFK");
        bt(res, tickets.size(), map);
        return res;
    }
    public boolean bt(List<String> res, int n, Map<String, List<String>> map) {
        if (n == 0) return true;
        String from = res.get(res.size() - 1);
        if (!map.containsKey(from)) return false;
        List<String> tos = map.get(from);
        for (int i = 0; i < tos.size(); i++) {
            String to = tos.get(i);
            tos.remove(i);
            res.add(to);

            if (bt(res, n - 1, map)) {
                return true;
            }

            tos.add(i, to);
            res.remove(res.size() - 1);
        }
        return false;
    }
}
// @lc code=end

