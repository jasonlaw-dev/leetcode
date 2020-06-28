/*
 * @lc app=leetcode id=1497 lang=java
 *
 * [1497] Check If Array Pairs Are Divisible by k
 */

// @lc code=start
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] buckets = new int[k];
        int match = 0;
        for (int i : arr) {
            int remainder = (i % k + k) % k;
            if (buckets[(k - remainder) % k] > 0) {
                buckets[(k - remainder) % k]--;
                match++;
            } else {
                buckets[remainder % k]++;
            }
        }
        return match == (arr.length / 2);
    }
}
// @lc code=end

