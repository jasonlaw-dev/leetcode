import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *  Time: O(n^2)
 *  Space: O(1)
 *  NOTE: just initialize result by using the sum of first 3 nums.
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int localClosest = 0;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (j == i + 1 && k == nums.length - 1 || Math.abs(target - sum) < Math.abs(target - localClosest) ) {
                    localClosest = sum;
                }
                
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
            if (i == 0 || Math.abs(target - closest) > Math.abs(target - localClosest)) {
                closest = localClosest;
            }
        }
        return closest;
    }
}
// @lc code=end

