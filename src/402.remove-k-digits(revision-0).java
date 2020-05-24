import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        if (k == 0) {
            return num;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char curr = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > curr) {
                stack.pop();
                k--;
            }
            stack.push(curr);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && stack.peekLast() == '0') stack.pollLast();
        while (stack.size() > k) {
            sb.append(stack.pollLast());
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
// @lc code=end

