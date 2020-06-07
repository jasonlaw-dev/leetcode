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
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int low = 1;
        int high = 1;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            high = Math.max(high, count);
            map.put(num, count);
        }
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            int ge = 0;
            for (int count : map.values()) {
                if (count >= mid) {
                    ge++;
                }
            }
            if (ge >= k) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (int num : map.keySet()) {
            if (map.get(num) >= low) {
                res[i++] = num;
                if (i == k) {
                    break;
                }
            }
        }

        return res;
    }
}
// @lc code=end

