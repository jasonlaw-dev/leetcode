/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int i = 0;
        int j = 0;
        int maxCount = 0;

        /*
        Since we are only interested in the longest valid substring, our sliding windows need not shrink, even if a window may cover an invalid substring. We either grow the window by appending one char on the right, or shift the whole window to the right by one. And we only grow the window when the count of the new char exceeds the historical max count (from a previous window that covers a valid substring).


        */
        while (j < s.length()) {
            maxCount = Math.max(maxCount, ++count[s.charAt(j) - 'A']);
            j++;

            if (maxCount + k < j - i) {
                count[s.charAt(i) - 'A']--;
                i++;
            }
        }
        return j - i;
    }
}
// @lc code=end

