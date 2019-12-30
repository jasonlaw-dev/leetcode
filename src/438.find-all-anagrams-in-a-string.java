import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || p.length() > s.length() ) return res;
        int[] count = new int[26];
        int remaining = 0;
        for (int i = 0; i < p.length(); i++) {
            int c = p.charAt(i) - 'a';
            if (count[c] == 0) {
                remaining++;
            }
            count[c]++;
        }
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (count[s.charAt(right) - 'a']-- == 1) {
                remaining--;
            }
            right++;
            while (right - left > p.length()) {
                if (count[s.charAt(left) - 'a']++ == 0) {
                    remaining++;
                }
                left++;
            }
            if (remaining == 0) {
                res.add(left);
            }
        }
        return res;
    }
}
// @lc code=end

