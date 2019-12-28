import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new ArrayDeque<>(T.length);
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peekLast()] < T[i]) {
                int j = stack.removeLast();
                res[j] = i - j;
            }
            stack.add(i);
        }
        return res;
    }
}
// @lc code=end

