import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        if (nums.length == 0) {
            return result;
        }
        int[] permsCache = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (!countMap.containsKey(nums[i])) {
                countMap.put(nums[i], 1);
            } else {
                countMap.put(nums[i], countMap.get(nums[i])+ 1);
            }
            if (i == 0) {
                permsCache[i + 1] = 1;
            } else {
                permsCache[i + 1] = permsCache[i] * (i+1);
            }
        }
        int perms = permsCache[nums.length];
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                perms = perms / permsCache[entry.getValue()];
            }
        }
        for (int i = 0; i < perms; i++) {
            result.add(new ArrayList<>());
        }
        bt(nums, countMap, result, 0, perms, 0);
        return result;
    }

    public void bt(int[] nums, Map<Integer, Integer> countMap, List<List<Integer>> result, int start, int len, int index) {
        if (index == nums.length) {
            return;
        }
        int newStart = start;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            int repeat = len * entry.getValue() / (nums.length - index);
            for (int j = 0; j < repeat; j++) {
                result.get(newStart + j).add(entry.getKey());
            }
            countMap.put(entry.getKey(), countMap.get(entry.getKey()) - 1);
            bt(nums, countMap, result, newStart, repeat, index + 1);
            countMap.put(entry.getKey(), countMap.get(entry.getKey()) + 1);
            newStart += repeat;
        }
    }
}
// @lc code=end

