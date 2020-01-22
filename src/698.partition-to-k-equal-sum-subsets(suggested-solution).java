import java.util.Arrays;

/*
 * @lc app=leetcode id=698 lang=java
 *
 * [698] Partition to K Equal Sum Subsets
 */

// @lc code=start
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        int end = nums.length - 1;
        if (nums[end] > target) return false;
        while (nums[end] == target) {
            end--;
            k--;
        }
        return canPartition(nums, k, target, new int[k], end);
    }
    public boolean canPartition(int[] nums, int k, int target, int[] groups, int end) {
        if (end < 0) {
            return true;
        }
        int curr = nums[end];
        for (int i = 0; i < k; i++) {
            if (groups[i] + curr <= target) {
                groups[i] += curr;
                if (canPartition(nums, k, target, groups, end - 1)) return true;
                groups[i] -= curr;
            }
            if (groups[i] == 0) {
                break;
            }
        }
        return false;
    }
}
// @lc code=end

