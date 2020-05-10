import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=962 lang=java
 *
 * [962] Maximum Width Ramp
 * 
 */

// @lc code=start
class Solution {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (stack.size() == 0 || A[stack.peek()] > A[i]) {
                stack.push(i);
            }
        }
        int res = 0;
        for (int i = A.length - 1; i > res; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}
// @lc code=end

