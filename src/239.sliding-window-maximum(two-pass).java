import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] results = new int[nums.length - k + 1];
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % k == 0) {
                leftMax[i] = nums[i];
            } else {
                leftMax[i] = Math.max(leftMax[i-1], nums[i]);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i % k == k - 1 || i == nums.length - 1) {
                rightMax[i] = nums[i];
            } else {
                rightMax[i] = Math.max(rightMax[i+1], nums[i]);
            }
        }
        for (int i = 0; i < nums.length - k + 1; i++) {
            results[i] = Math.max(rightMax[i], leftMax[i+k-1]);
        }
        return results;
    }
}
// @lc code=end

