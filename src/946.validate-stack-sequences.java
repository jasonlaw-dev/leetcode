import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=946 lang=java
 *
 * [946] Validate Stack Sequences
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        int n = 0; // stack size;
        for (; i < pushed.length; i++) {
            pushed[n++] = pushed[i];
            while (n > 0 && popped[j] == pushed[n - 1]) {
                n--;
                j++;
            }
        }
        return n == 0;
    }
}
// @lc code=end

