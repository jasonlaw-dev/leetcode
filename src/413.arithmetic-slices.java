/*
 * @lc app=leetcode id=413 lang=java
 *
 * [413] Arithmetic Slices
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int i = 0;
        int j = 2;
        while (j <= A.length) {
            int diff = j != A.length ? A[j] - A[j - 1] : Integer.MAX_VALUE;
            if (diff != A[i + 1] - A[i]) {
                if (j - i > 2) {
                    int len = j - i - 2;
                    count += (1 + len) * len / 2;
                }
                i = j - 1;
            }
            j++;
        }
        return count;
    }
}
// @lc code=end

