import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * @lc app=leetcode id=632 lang=java
 *
 * [632] Smallest Range Covering Elements from K Lists
 */

// @lc code=start
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                map.computeIfAbsent(num, k -> new HashSet<>());
                map.get(num).add(i);
            }
        }
        List<Integer> sortedNums = new ArrayList<>(map.keySet());
        Collections.sort(sortedNums);

        int[] res = new int[]{ sortedNums.get(0), sortedNums.get(sortedNums.size() - 1) };

        int[] count = new int[nums.size()];
        int unique = 0;
        boolean found = false;
        for (int i = 0, j = 0; j < sortedNums.size(); j++) {
            for (int idx : map.get(sortedNums.get(j))) {
                if (count[idx]++ == 0) {
                    unique++;
                }
            }
            while (unique >= nums.size()) {
                if (sortedNums.get(j) - sortedNums.get(i) < res[1] - res[0]) {
                    res[0] = sortedNums.get(i);
                    res[1] = sortedNums.get(j);

                    if (res[1] - res[0] == 0) {
                        found = true;
                        break;
                    }
                }
                for (int idx : map.get(sortedNums.get(i))) {
                    if (count[idx]-- == 1) {
                        unique--;
                    }
                }
                i++;
            }
            if (found) {
                break;
            }
        }
        return res;

    }
}
// @lc code=end

