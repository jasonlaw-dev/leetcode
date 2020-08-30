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

