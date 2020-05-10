import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int a = A[i], b = A[j], l = 2;
                while (set.contains(a + b)) {
                    b = a + b;
                    a = b - a;
                    l++;
                }
                max = Math.max(max, l);
            }
        }
        return max > 2 ? max : 0;
    }

}
// @lc code=end

