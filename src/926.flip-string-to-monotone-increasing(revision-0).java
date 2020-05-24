/*
 * @lc app=leetcode id=926 lang=java
 *
 * [926] Flip String to Monotone Increasing
 */

// @lc code=start
class Solution {
    public int minFlipsMonoIncr(String S) {
        int end0 = 0;
        int end1 = 0;
        int n = S.length();
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '0') {
                end1 = Math.min(end0, end1) + 1;
            } else {
                end1 = Math.min(end0, end1);
                end0++;
            }
        }
        return Math.min(end0, end1);
    }
}
// @lc code=end

