import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=638 lang=java
 *
 * [638] Shopping Offers
 */

// @lc code=start
class Solution {
    
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, 0);
    }
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int idx) {
        // int key = needsToKey(needs);
        // if (map.containsKey(key)) return map.get(key);
        int min = 0;
        for (int i = 0; i < needs.size(); i++) {
            min += price.get(i) * needs.get(i);
        }
        for (int s = idx; s < special.size(); s++) {
            List<Integer> spec = special.get(s);
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < needs.size(); i++) {
                if (spec.get(i) > needs.get(i)) {
                    break;
                }
                next.add(needs.get(i) - spec.get(i));
            }
            if (next.size() == needs.size()) {
                min = Math.min(min, spec.get(spec.size() - 1) + dfs(price, special, next, s));
            }
        }
        // map.put(key, min);
        return min;
    }
}
// @lc code=end

