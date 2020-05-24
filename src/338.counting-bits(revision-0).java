/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int[] result = new int[num+1];
        result[0] = 0;
        result[1] = 1;
        int k = 1;
        for (int i = 2; i <= num; i++) {
            if (i == k * 2) {
                result[i] = 1;
                k *= 2;
            } else {
                result[i] = result[i - k] + result[k];
            }
        }
        return result;
    }
}
// @lc code=end

