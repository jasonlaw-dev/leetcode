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
        if (s.length() <= 1) {
            return s.length();
        }
        HashSet<Character> set = new HashSet<>();
        int globalMax = 0;
        int max = 0;
        int left = 0;
        int right = 0;
        while (true) {
            if (right >= s.length()) {
                break;
            }
            char leftChar;
            char rightChar = ' ';
            while (right < s.length()) {
                rightChar = s.charAt(right);
                right++;
                if (set.contains(rightChar)) {
                    break;
                }
                set.add(rightChar);
                max++;
                if (max > globalMax) {
                    globalMax = max;
                }
            }
            if (right == s.length()) {
                break;
            }
            while (left < right) {
                leftChar = s.charAt(left);
                left++;
                if (leftChar == rightChar) {
                    break;
                }
                set.remove(leftChar);
                max--;
            }
        }
        return globalMax;
    }
}
// @lc code=end

