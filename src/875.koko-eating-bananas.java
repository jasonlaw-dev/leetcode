/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 * 
 * binary search?
 * lower bound = ??
 * upper bound = max(piles[i])
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1;
        for (int pile : piles) hi = Math.max(hi, pile);

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int count = 0;
            for (int pile : piles) {
                count += (pile + mid - 1) / mid;
            }
            if (count > H) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
// @lc code=end

