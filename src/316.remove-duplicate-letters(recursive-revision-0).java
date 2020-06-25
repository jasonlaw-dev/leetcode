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
      for (int i = 0; i < s.length(); i++) {
        count[s.charAt(i) - 'a']++;
      }
      int pos = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) < s.charAt(pos)) {
          pos = i;
        }
        if (count[s.charAt(i) - 'a']-- == 1) {
          break;
        }
      }
      return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replace(s.charAt(pos) + "", ""));
    }
}
// @lc code=end

