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
        return canPartition(nums, k, target, 0, 0, new boolean[nums.length]);
    }
    public boolean canPartition(int[] nums, int k, int target, int currSum, int startIndex, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        if (currSum > target) return false;
        if (currSum == target) return canPartition(nums, k - 1, target, 0, 0, visited);
        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canPartition(nums, k, target, currSum + nums[i], i + 1, visited)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
// @lc code=end

