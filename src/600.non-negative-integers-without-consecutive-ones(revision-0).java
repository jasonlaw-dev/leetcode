/*
 * @lc app=leetcode id=600 lang=java
 *
 * [600] Non-negative Integers without Consecutive Ones
 * 
 * bit
 * 0 | 1 2 3
 * 1 | 1 1 2
 * 
 * 10101
 * 00000
 * 
 * xxxx0 to xxxx1 (2)
 * xxx00 to xxx01 (0)
 * xx000 to xx011 (3)
 * 
 * 11101
 */

// @lc code=start
class Solution {
    public int findIntegers(int num) {
        int res = 0;
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        int prevBit = 0;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 1) {
                res += dp[i];
                if (prevBit == 1) {
                    return res;
                }
            }
            prevBit = bit;
        }
        return res + 1;
    }
}
// @lc code=end

