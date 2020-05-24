/*
 * @lc app=leetcode id=679 lang=java
 *
 * [679] 24 Game
 * 
 * 1 , 3 or 2,2 
 * [3], separate into 
 */

// @lc code=start
class Solution {
    public boolean judgePoint24(int[] nums) {
        double[] doubleNums = new double[4];
        for (int i = 0; i < 4; i++) doubleNums[i] = nums[i];
        return helper(doubleNums);
    }
    public boolean helper(double[] nums) {
        if (nums.length == 1) {
            return Math.abs(nums[0] - 24.0) < 0.0001;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                double[] next = new double[nums.length - 1];
                for (int k = 0, idx = 0; k < nums.length; k++) {
                    if (k != i && k != j) {
                        next[idx++] = nums[k];
                    }
                }
                double x = nums[i];
                double y = nums[j];
                double[] cands = new double[]{ x + y, x - y, y - x, x * y };
                for (double cand : cands) {
                    next[next.length - 1] = cand;
                    if (helper(next)) return true;
                }
                if (Math.abs(x) > 0.0001) {
                    next[next.length - 1] = y / x;
                    if (helper(next)) return true;
                }
                if (Math.abs(y) > 0.0001) {
                    next[next.length - 1] = x / y;
                    if (helper(next)) return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

