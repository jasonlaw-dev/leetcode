/*
 * @lc app=leetcode id=798 lang=java
 *
 * [798] Smallest Rotation with Highest Score
 */

// @lc code=start
class Solution {
    public int bestRotation(int[] A) {
        int n = A.length;
        int[] chg = new int[n];
        for (int i = 0; i < n; i++) {
            if (A[i] <= i) {
                chg[0]++;
            }
            chg[(i + 1) % n]++;
            chg[(i + 1 - A[i] + n) % n]--;
        }
        int sum = 0;
        int max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += chg[i];
            if (sum > max) {
                max = sum;
                res = i;
            }
        }
        return res;
    }
}
// @lc code=end

