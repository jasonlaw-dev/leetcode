import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = 1;
        int max = 1;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            max = Math.max(max, count);
            map.put(num, count);
        }
        while (min < max) {
            int mid = min + (max - min + 1) / 2;
            int count = 0;
            for (int value : map.values()) {
                if (value >= mid) {
                    count++;
                }
            }
            if (count >= k) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        int cutoff = min;
        List<Integer> res = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) >= cutoff) {
                res.add(key);
            }
        }
        return res;
    }
}
// @lc code=end

