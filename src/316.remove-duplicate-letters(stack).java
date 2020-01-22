import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        int uniqueCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
          if (count[s.charAt(i) - 'a']++ == 0) {
            uniqueCount++;
          }
        }
        Deque<Character> stack = new ArrayDeque<>(uniqueCount);
        for (int i = 0; i < s.length(); i++) {
          char curr = s.charAt(i);
          if (!visited[curr - 'a']) {
            while (
              !stack.isEmpty()
               && curr < stack.peek()
               && count[stack.peek() - 'a'] > 0
            ) {
              visited[stack.pop() - 'a'] = false;
            }
            stack.push(curr);
            visited[curr - 'a'] = true;  
          }
          count[curr - 'a']--;
        }
        char[] res = new char[uniqueCount];
        for (int i = uniqueCount - 1; i >= 0; i--) {
          res[i] = stack.pop();
        }
        return new String(res);
    }
}
// @lc code=end

