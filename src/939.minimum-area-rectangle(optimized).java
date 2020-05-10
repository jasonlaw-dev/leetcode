import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=939 lang=java
 *
 * [939] Minimum Area Rectangle
 */

// @lc code=start
class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int[] point : points) {
            rows.add(point[0]);
            cols.add(point[1]);
        }
        if (rows.size() > cols.size()) {
            for (int[] point : points) {
                if (!map.containsKey(point[0])) map.put(point[0], new ArrayList<>());
                map.get(point[0]).add(point[1]);
            }
        } else {
            for (int[] point : points) {
                if (!map.containsKey(point[1])) map.put(point[1], new ArrayList<>());
                map.get(point[1]).add(point[0]);
            }
        }

        List<Integer> sortedPoint1 = new ArrayList<>(map.keySet());
        Collections.sort(sortedPoint1);

        Map<Integer, Integer> previousComb = new HashMap<>();
        int area = Integer.MAX_VALUE;
        for (int x : sortedPoint1) {
            List<Integer> sortedPoint2 = map.get(x);
            Collections.sort(sortedPoint2);
            for (int i = 0; i <sortedPoint2.size(); i++) {
                for (int j = 0; j < i; j++) {
                    int key = sortedPoint2.get(i) * 40001 + sortedPoint2.get(j);
                    if (previousComb.containsKey(key)) {
                        area = Math.min(area, (sortedPoint2.get(i) - sortedPoint2.get(j)) * (x - previousComb.get(key)));
                    }
                    previousComb.put(key, x);
                }
            }
        }
        return area == Integer.MAX_VALUE ? 0 : area;
    }
}
// @lc code=end

