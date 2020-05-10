/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 * 
 * trivial solution, compute cumulative sum, use O(n^2) to find every combination
 * can we do O(n) or O(n log n?)
 */



// @lc code=start
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int[] count = new int[K];
        count[0] = 1;
        int res = 0;
        for (int num : A) {
            sum = (sum + num) % K;
            if (sum < 0) {
                sum += K;
            }
            res += count[sum];
            count[sum]++;
        }
        return res;
    }
}
// @lc code=end

