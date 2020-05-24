/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int seq1 = Integer.MAX_VALUE;
        int seq2 = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num < seq1) {
                seq1 = num;
            } else if (num > seq1 && num < seq2) {
                seq2 = num;
            } else if (num > seq2) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

