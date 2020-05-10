import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=873 lang=java
 *
 * [873] Length of Longest Fibonacci Subsequence
 * 
 * backtracking
 *  finding all pairs -> O(n^2), for each pair, we can potentially loop thru all elements in the array -> O(n^3)
 *  can use memoization
 * 
 */

// @lc code=start
class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int res = 0;
        int[][] dp = new int[A.length][A.length];
        Map<Integer, Integer> index = new HashMap<>();
        for (int j = 0; j < A.length; j++) {
            index.put(A[j], j);
            for (int i = 0; i < j; i++) {
                int k = index.getOrDefault(A[j] - A[i], -1);
                dp[i][j] = (A[j] - A[i] < A[i] && k >= 0) ? dp[k][i] + 1 : 2;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res > 2 ? res : 0;
    }

}
// @lc code=end

