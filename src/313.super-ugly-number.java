import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=313 lang=java
 *
 * [313] Super Ugly Number
 * 
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ugly[i] = Math.min(ugly[i], ugly[idx[j]] * primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                while (ugly[i] >= ugly[idx[j]] * primes[j]) {
                    idx[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
}
// @lc code=end

