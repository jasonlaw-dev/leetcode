/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        long low = Integer.MIN_VALUE;
        long high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (valid(nums, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }
    private boolean valid(int[] nums, int m, long target) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                m--;
                if (m == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
// @lc code=end

