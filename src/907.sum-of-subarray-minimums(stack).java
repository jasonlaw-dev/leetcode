import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 */

// @lc code=start
class Solution {
    public int sumSubarrayMins(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        Arrays.fill(left, -1);
        Arrays.fill(right, A.length);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                right[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        int sum = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * (i - left[i]) * (right[i] - i);
            sum %= mod;
        }
        return sum;
    }
}
// @lc code=end

