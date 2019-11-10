import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums); // O(n log(n))
        Map<Integer, Integer> map = new HashMap<>(); // now, it will be hash table which each value as the greatest index
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Integer prevNum1 = null;
        Integer prevNum2 = null;
        for (int i = 0; i < nums.length - 1; i++) {
            int num1 = nums[i];
            if (prevNum1 != null && num1 == prevNum1) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if (prevNum2 != null && num2 == prevNum2) {
                    continue;
                }
                int target = 0 - num1 - num2;
                Integer targetIndex = map.get(target);
                if (targetIndex != null && targetIndex > j) {
                    results.add(Arrays.asList(num1, num2, target));
                }
                prevNum2 = num2;
            }
            prevNum1 = num1;
        }
        return results;
    }
}
// @lc code=end

