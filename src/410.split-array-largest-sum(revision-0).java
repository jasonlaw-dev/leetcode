/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0; long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        long lo = max;
        long hi = sum;
        if (m == 1) {
            return (int)sum;
        }
        while (lo < hi) {
            long mid = lo + (hi - lo) /2;
            if (tooManyPartitions(nums, m, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (int)lo;
    }
    public boolean tooManyPartitions(int[] nums, int m, long target) {
        int count = 1;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                count++;
                if (count > m) {
                    return true;
                }
            }
        }
        return false;
    }
}

// @lc code=end

