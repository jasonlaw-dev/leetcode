/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int minusTwo = 1;
        int minusOne = 2;
        for (int i = 3; i <= n; i++) {
            int temp = minusOne + minusTwo;
            minusTwo = minusOne;
            minusOne = temp;
        }
        return minusOne;
    }
}
// @lc code=end

