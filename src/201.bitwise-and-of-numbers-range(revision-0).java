/*
 * @lc app=leetcode id=201 lang=java
 *
 * [201] Bitwise AND of Numbers Range
 * // need to check most significant bit
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        for (int mask = 1 << 31; mask != 0; mask >>>= 1) {
            if ((m & mask) == (n & mask)) {
                res |= (m & mask);
            } else {
                break;
            }
        }
        return res;
    }
}
// @lc code=end

