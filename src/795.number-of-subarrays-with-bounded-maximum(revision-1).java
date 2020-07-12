import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=795 lang=java
 *
 * [795] Number of Subarrays with Bounded Maximum
 * 
 * 2 3 2 5 1 2 3 1 0 2
 */

// @lc code=start
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int start = 0;
        int end = -1;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= L && A[i] <= R) {
                end = i;
                res += end - start + 1;
            } else if (A[i] > R) {
                start = i + 1;
                end = i;
            } else {
                res += end - start + 1;
            }
        }
        return res;
    }
}
// @lc code=end

