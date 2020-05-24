/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        if (s1.length() == 0) return true;

        int[] count = new int[26];
        int unique = 0;
        for (int i = 0; i < s1.length(); i++) {
            int c = s1.charAt(i) - 'a';
            if (count[c]++ == 0) {
                unique++;
            }
        }
        int i = 0;
        int j = 0;
        while (j < s2.length()) {
            if (count[s2.charAt(j) - 'a']-- == 1) {
                unique--;
            }
            j++;
            while (j - i > s1.length()) {
                if (count[s2.charAt(i) - 'a']++ == 0) {
                    unique++;
                }
                i++;
            }
            if (unique == 0) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

