import java.util.HashSet;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

 // Time: O(n)
 // Space: O(n)

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] count = new int[256];
        int i = 0;
        int j = 0;
        for (; j < s.length(); j++) {
            int c = s.charAt(j);
            count[c]++;
            while (count[c] > 1) {
                count[s.charAt(i)]--;
                i++;
            }
            res = Math.max(j - i + 1, res);
        }
        return res;
    }
}
// @lc code=end

