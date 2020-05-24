import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Sequence
 */

// @lc code=start
class Solution {
    public int longestArithSeqLength(int[] A) {
        List<Map<Integer, Integer>> maps = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            maps.add(map);
            for (int j = 0; j < i; j++) {
                Map<Integer, Integer> prevMap = maps.get(j);
                int diff = A[i] - A[j];
                int len = prevMap.getOrDefault(diff, 1) + 1;
                map.put(diff, len);
                res = Math.max(len, res);
            }
        }
        return res;
    }
}
// @lc code=end

