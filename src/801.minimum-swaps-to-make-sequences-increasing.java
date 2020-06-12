/*
 * @lc app=leetcode id=801 lang=java
 *
 * [801] Minimum Swaps To Make Sequences Increasing
 */

// @lc code=start
class Solution {

    
    public int minSwap(int[] A, int[] B) {
        int prevNoSwap = 0;
        int prevSwap = 1;
        int currNoSwap = 0;
        int currSwap = 0;
        for (int i = 1; i < A.length; i++) {
            boolean noSwap = isIncreasing(A[i - 1], A[i], B[i - 1], B[i]);
            boolean swap = isIncreasing(A[i - 1], B[i], B[i - 1], A[i]);

            if (noSwap && swap) {
                currNoSwap = Math.min(prevNoSwap, prevSwap);
                currSwap = 1 + currNoSwap;
            } else if (noSwap) {
                currNoSwap = prevNoSwap;
                currSwap = 1 + prevSwap;
            } else if (swap) {
                currNoSwap = prevSwap;
                currSwap = 1 + prevNoSwap;
            }
            prevNoSwap = currNoSwap;
            prevSwap = currSwap;
        }
        return Math.min(prevSwap, prevNoSwap);
    }

    public boolean isIncreasing(int a, int b, int x, int y) {
        return a < b && x < y;
    }
}
// @lc code=end

