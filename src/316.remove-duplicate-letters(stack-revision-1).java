import java.util.Stack;

/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int unique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a']++ == 0) {
                unique++;
            }
        }
        Stack<Character> stack = new Stack<>();
        boolean[] used = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!used[c - 'a']) {
                while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                    used[stack.pop() - 'a'] = false;
                }
                stack.push(c);
                used[c - 'a'] = true;
            }
            count[c - 'a']--;
        }
        char[] res = new char[unique];
        for (int i = unique - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return new String(res);
    }
}
// @lc code=end

