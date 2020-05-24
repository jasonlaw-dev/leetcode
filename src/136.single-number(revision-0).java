/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int n :nums) {
            num ^= n;
        }
        return num;
    }
}
// @lc code=end

