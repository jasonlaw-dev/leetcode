import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return count(nums, target, new HashMap<>());
    }
    private int count(int[] nums, int target, Map<Integer, Integer> map) {
        if (target == 0) {
            return 1;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > target) {
                continue;
            }
            sum += count(nums, target - nums[i], map);
        }
        map.put(target, sum);
        return sum;
    }
}
// @lc code=end

