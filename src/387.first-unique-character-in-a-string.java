/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] array = s.toCharArray();
        for (char c : array) {
            count[c - 'a']++;
        }
        for (int i = 0; i < array.length; i++) {
            if (count[array[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

