import java.util.Stack;

/*
 * @lc app=leetcode id=277 lang=java
 *
 * [277] Find the Celebrity
 */

// @lc code=start
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n == 0) return -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (knows(a, b)) {
                stack.add(b);
            } else if (knows(b, a)) {
                stack.add(a);
            }
        }
        if (stack.isEmpty()) {
            return -1;
        }
        int cand = stack.pop();
        for (int i = 0; i < n; i++) {
            if (cand != i && (!knows(i, cand) || knows(cand, i))) {
                return -1;
            }
        }
        return cand;
    }
}
// @lc code=end

