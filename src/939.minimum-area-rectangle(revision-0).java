import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=939 lang=java
 *
 * [939] Minimum Area Rectangle
 */

// @lc code=start
class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            add(map, point[0], point[1]);
        }
        int area = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] a = points[i];
                int[] b = points[j];
                if (a[0] != b[0] && a[1] != b[1] && map.containsKey(a[0]) && map.get(a[0]).contains(b[1])
                    && map.containsKey(b[0]) && map.get(b[0]).contains(a[1]) 
                ) {
                    area = Math.min(Math.abs((a[0] - b[0]) * (a[1] - b[1])), area);
                }
            }
        }
        return area == Integer.MAX_VALUE ? 0 : area;
    }
    private void add(Map<Integer, Set<Integer>> map, int key, int value) {
        if (!map.containsKey(key)) {
            map.put(key, new HashSet<>());
        }
        map.get(key).add(value);
    }
}
// @lc code=end

