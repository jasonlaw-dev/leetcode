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

        boolean[] used = new boolean[nums.length];
        return fill(nums, used, sum / 4, 0, 0, nums.length - 1);
    }

    public boolean fill(int[] nums, boolean[] used, int target, int curr, int bucket, int i) {
        if (bucket == 4) return true;
        for (int j = i; j >= 0; j--) {
            if (!used[j] && nums[j] + curr <= target) {
                used[j] = true;
                curr += nums[j];
                if (curr != target) {
                    if (fill(nums, used, target, curr, bucket, j - 1)) {
                        return true;
                    }
                } else {
                    if (fill(nums, used, target, 0, bucket + 1, nums.length - 1)) {
                        return true;
                    }
                }
                curr -= nums[j];
                used[j] = false;

                while (j > 0 && nums[j] == nums[j - 1]) {
                    j--;
                }
            }
        }
        return false;
    }

}
// @lc code=end

