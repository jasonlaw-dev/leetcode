/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */

// NOTE: think about edge cases!!!

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int product = 1;
        while (n > 4) {
            product *= 3;
            n-=3;
        }
        product *= n;
        return product;
    }
}
// @lc code=end

