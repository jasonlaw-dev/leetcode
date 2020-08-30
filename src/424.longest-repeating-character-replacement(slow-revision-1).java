/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    private int findMaxCount(int[] count) {
        int max = 0;
        for (int num : count) {
            max = Math.max(num, max);
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int res = 0;
        int maxCount = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(j) - 'A']);
            while ((j - i + 1) - maxCount > k) {
                count[s.charAt(i) - 'A']--;
                i++;
                maxCount = findMaxCount(count);
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
// @lc code=end

