/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        if (s.length() == 0) {
            return 0;
        }
        boolean[][] pal = new boolean[s.length()][s.length()];
        int[] cuts = new int[s.length()];
        for (int right = 0; right < s.length(); right++) {
            cuts[right] = right;
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left < 2 || pal[left + 1][right - 1])) {
                    pal[left][right] = true;
                    cuts[right] = left == 0 ? 0 : Math.min(cuts[left - 1] + 1, cuts[right]);
                }
            }
        }
        return cuts[s.length() - 1];
    }
    
}
// @lc code=end

