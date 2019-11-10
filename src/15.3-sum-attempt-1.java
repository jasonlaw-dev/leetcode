import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 * 
 *  Note: TreeMap is slow if we constantly use tailmap
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        TreeMap<Integer, HashSet<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new HashSet<>());
            }
            map.get(nums[i]).add(i);
        }
        List<List<Integer>> results = new ArrayList<>();
        for (Map.Entry<Integer, HashSet<Integer>> entry1 : map.entrySet()) {
            int num1 = entry1.getKey();
            for (Map.Entry<Integer, HashSet<Integer>> entry2 : map.tailMap(num1).entrySet()) {
                int num2 = entry2.getKey();
                if (num1 == num2 && entry1.getValue().size() <= 1) {
                    continue;
                }
                int target = 0 - num1 - num2;
                if (target == num1 && target == num2) {
                    if (entry1.getValue().size() <= 2) {
                        continue;
                    }
                } else if (target == num1) {
                    if (entry1.getValue().size() <= 1) {
                        continue;
                    }
                } else if (target == num2) {
                    if (entry2.getValue().size() <= 1) {
                        continue;
                    }
                }
                if (target < num2 || target < num1) {
                    continue;
                }
                if (map.containsKey(target)) {
                    results.add(Arrays.asList(num1, num2, target));
                }
            }
        }
        return results;
    }
}
// @lc code=end

