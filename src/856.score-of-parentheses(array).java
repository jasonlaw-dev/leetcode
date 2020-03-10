import java.util.Stack;

/*
 * @lc app=leetcode id=856 lang=java
 *
 * [856] Score of Parentheses
 */

// @lc code=start
class Solution {
    public int scoreOfParentheses(String S) {
        int[] A = new int[S.length() / 2 + 1];
        int k = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                k++;
            } else {
                int prev = A[k];
                A[k] = 0;
                k--;
                if (S.charAt(i - 1) == '(') {
                    A[k] += 1;
                } else {
                    A[k] += 2 * prev;
                }
            }
        }
        return A[0];
    }
}
// @lc code=end

