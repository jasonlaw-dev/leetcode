import java.util.Arrays;

/*
 * @lc app=leetcode id=473 lang=java
 *
 * [473] Matchsticks to Square
 */

// @lc code=start
class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        Arrays.sort(nums);

        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0 || sum / 4 < nums[nums.length - 1]) return false;

        int[] buckets = new int[4];

        return fill(nums, buckets, sum / 4, nums.length - 1);
    }

    public boolean fill(int[] nums, int[] buckets, int target, int index) {
        if (index == -1) return true;
        for (int bucket = 0; bucket < 4; bucket++) {
            if (buckets[bucket] + nums[index] <= target) {
                buckets[bucket] += nums[index];
                if (fill(nums, buckets, target, index - 1)) {
                    return true;
                }
                buckets[bucket] -= nums[index];
                if (buckets[bucket] == 0) return false;
            }
        }
        return false;
    }

}
// @lc code=end

