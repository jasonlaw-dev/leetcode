/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 * 
 * int sum =0;
 * int sign = 1 or -1;
 * 
 * when we meet + -
 * then we should compute prev (op) curr, -> add to sum
 * 
 * when we meet * /
 * compute if curr op is * or /, move result to prev, set curr = 0
 * move curr to prev, 
 * 
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int sum = 0;
        int prev = 0;
        int curr = 0;
        char op = '+';
        for (int i = 0; i <= s.length(); i++) {
            char c = i == s.length() ? '+' : s.charAt(i);
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                curr = curr * 10 + (c - '0');
            } else {
                if (op == '+' || op == '-') {
                    sum += prev;
                    prev = curr * (op == '+' ? 1 : -1);
                } else {
                    prev = compute(prev, curr, op);
                }
                op = c;
                curr = 0;
            }
        }
        return sum + prev;
    }
    private int compute(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        }
        if (op == '-') {
            return a - b;
        }
        if (op == '*') {
            return a * b;
        }
        return a / b;
    }
}
// @lc code=end

