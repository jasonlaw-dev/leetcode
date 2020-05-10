import java.util.Stack;

/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 * 
 * < < < > 
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int num : asteroids) {
            if (num < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -num) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(num);
                } else if (stack.peek() == -num) {
                    stack.pop();
                }
            } else {
                stack.push(num);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
// @lc code=end

