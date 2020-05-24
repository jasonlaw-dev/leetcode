/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 * 
 * two pointers
 * count number of zeros and ones
 * 
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] A, int K) {
        int max = 0;
        int zeros = 0;
        
        int i = 0;
        int j = 0;
        
        while (j < A.length) {
            if (A[j] == 0) {
                zeros++;
            }
            j++;
            while (zeros > K) {
                if (A[i] == 0) {
                    zeros--;
                }
                i++;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}
// @lc code=end

