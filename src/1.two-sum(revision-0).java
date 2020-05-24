import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// Time: O(n)
// Space: O(n)

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer match = map.get(target - nums[i]);
            if (match != null) {
                result[0] = match;
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
// @lc code=end

