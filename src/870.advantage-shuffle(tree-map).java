import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=870 lang=java
 *
 * [870] Advantage Shuffle
 * 
 * brute force O(n ^ 2), if no advantage at current index, try to swap until we have
 * sort both array, use two pointers to find the result => O(n log (n))
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : A) map.put(num, map.getOrDefault(num, 0) + 1);
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            Map.Entry<Integer, Integer> cand = map.higherEntry(B[i]);
            if (cand == null) {
                cand = map.firstEntry();
            }
            res[i] = cand.getKey();
            if (cand.getValue() == 1) {
                map.remove(cand.getKey());
            } else {
                map.put(cand.getKey(), cand.getValue() - 1);
            }
        }
        return res;
    }
}
// @lc code=end

