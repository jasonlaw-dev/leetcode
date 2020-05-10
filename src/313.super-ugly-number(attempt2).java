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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        for (int i = 1; i < n; i++) {
            int val = pq.poll();
            for (int prime :primes) {
                if ((long) val * prime <= Integer.MAX_VALUE) {
                    pq.add(val * prime);    
                }
            }
            while (pq.peek() == val) pq.poll();
        }
        return pq.poll();
    }
}
// @lc code=end

