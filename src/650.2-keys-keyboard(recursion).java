/*
 * @lc app=leetcode id=650 lang=java
 *
 * [650] 2 Keys Keyboard
 */

// @lc code=start
class Solution {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        for (int k = 2; k <= n / 2; k++) {
            if (n % k == 0) {
                return minSteps(n / k) + k;
            }
        }
        return n;
    }
}
// @lc code=end

