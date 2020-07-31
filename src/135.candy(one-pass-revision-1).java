/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        int prev = 1;
        int decreasingCount = 0;
        int res = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i - 1]) {
                decreasingCount++;
                res += decreasingCount;
            } else {
                if (decreasingCount > 0) {
                    if (decreasingCount >= prev) {
                        res += decreasingCount - prev + 1;
                    }
                    decreasingCount = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
                res += prev;
            }
        }
        if (decreasingCount > 0) {
            if (decreasingCount >= prev) {
                res += decreasingCount - prev + 1;
            }
        }
        return res;
    }
}
// @lc code=end

