import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=1488 lang=java
 *
 * [1488] Avoid Flood in The City
 */

// @lc code=start
class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        TreeSet<Integer> treeSet = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = rains.length - 1; i >= 0; i--) {
            if (rains[i] == 0) {
                treeSet.add(i);
                res[i] = 1;
            } else {
                if (map.containsKey(rains[i])) {
                    int last = map.get(rains[i]);
                    Integer goodSpot = treeSet.lower(last);
                    if (goodSpot == null) {
                        return new int[0];
                    }
                    res[goodSpot] = rains[i];
                    treeSet.remove(goodSpot);
                }
                map.put(rains[i], i);
                res[i] = -1;
            }
        }
        return res;
    }
}
// @lc code=end

