/*
 * @lc app=leetcode id=1482 lang=java
 *
 * [1482] Minimum Number of Days to Make m Bouquets
 */

// @lc code=start
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) {
            return -1;
        }
        int low = 1;
        int high = 1000000000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0, flower = 0; i < n; i++) {
                if (bloomDay[i] > mid) {
                    flower = 0;
                } else if (++flower == k) {
                    flower = 0;
                    if (++count == m) {
                        break;
                    } 
                }
            }
            if (count < m) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
// @lc code=end

