/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 */

// @lc code=start
class Solution {
    int[] map = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!smallerEqual(words[i - 1], words[i])) {
                return false;
            }
        }
        return true;
    }
    private boolean smallerEqual(String a, String b) {
        int n = Math.min(a.length(), b.length());
        for (int i = 0; i < n; i++) {
            int x = map[a.charAt(i) - 'a'];
            int y = map[b.charAt(i) - 'a'];
            if (x != y) {
                return x < y;
            }
        }
        return a.length() <= b.length();
    }
}
// @lc code=end

