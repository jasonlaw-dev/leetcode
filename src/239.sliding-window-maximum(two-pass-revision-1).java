import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(nums[i], left[i - 1]);
            }
        }
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i % k == k - 1) {
                right[i] = nums[i];
            } else {
                right[i] = Math.max(nums[i], right[i + 1]);
            }
        }
        for (int i = k - 1; i < nums.length; i++) {
            res[i - k + 1] = Math.max(left[i], right[i - k + 1]);
        }
        return res;
    }
}
// @lc code=end

