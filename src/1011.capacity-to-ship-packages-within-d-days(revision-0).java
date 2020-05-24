/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// lower bound: max weight
// upper bound: sum of weights
// do a binary search
// calculate presums
// for each trial, check the days needed
// if needed > required, lo = mid + 1
// if needed < required, hi = mid
// what's the condition? lo < hi
// what's the mid point ? mid = lo + (hi - lo)/2

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int lo = 0;
        int hi = 0;
        for (int i = 0; i < weights.length; i++) {
            lo = Math.max(lo, weights[i]);
            hi += weights[i];
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int days = 1;
            int sum = 0;
            for (int i = 0; i < weights.length; i++) {
                sum += weights[i];
                if (sum > mid) {
                    days++;
                    sum = weights[i];
                }
            }

            if (days <= D) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
// @lc code=end

