/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

 // upper bound O(n^3)
 // how to improve to O(n^2) or better?

// 1 2 2 2 2 2 2 3 3

// @lc code=start
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int s = 0;
        int e = 0;
        int prefix = 0;
        int res = 0;
        int[] count = new int[A.length + 1];
        int unique = 0;
        while (e < A.length) {
            if (count[A[e]]++ == 0) {
                unique++;
            }
            e++;

            if (unique > K) {
                count[A[s]]--;
                s++;
                unique--;
                prefix = 0;
            }

            while (count[A[s]] > 1) {
                count[A[s]]--;
                s++;
                prefix++;
            }
            if (unique == K) {
                res += 1 + prefix;
            }
        }
        return res;
    }
}
// @lc code=end

