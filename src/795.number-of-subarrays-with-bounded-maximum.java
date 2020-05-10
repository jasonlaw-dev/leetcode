import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=795 lang=java
 *
 * [795] Number of Subarrays with Bounded Maximum
 * [2, 1, 2, 0]
 * record the last index that >= L
 */



// @lc code=start
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res = 0;
        int count = 0;
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= L && A[i] <= R) {
                count = i - j + 1;
                res += count;
            } else if (A[i] > R) {
                count = 0;
                j = i + 1;
            } else {
                res += count;
            }
        }
        return res;
    }
}
// @lc code=end

