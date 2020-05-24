import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        if (k == 0 || s.length() == 0) return s.length();
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        List<Integer> breaks = new ArrayList<>();
        breaks.add(-1);
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            if (counts[j] > 0 && counts[j] < k) {
                breaks.add(i);
            }
        }
        if (breaks.size() == 1) return s.length();
        breaks.add(s.length());
        int max = 0;
        for (int i = 1; i < breaks.size(); i++) {
            int start = breaks.get(i-1) + 1;
            int end = breaks.get(i);            
            max = Math.max(max, longestSubstring(s.substring(start, end), k));
        }
        return max;
    }

}
// @lc code=end

