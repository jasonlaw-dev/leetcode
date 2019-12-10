import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() == 0 || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        int remainingChars = 0;
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                remainingChars++;
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                int jCount = map.get(rightChar);
                if (jCount == 1) {
                    remainingChars--;
                }
                map.put(rightChar, jCount - 1);

                while (remainingChars == 0) {
                    char leftChar = s.charAt(left);
                    if (map.containsKey(leftChar)) {
                        int iCount = map.get(leftChar);
                        if (iCount == 0) {
                            remainingChars++;
                            if (right - left + 1 < minLen) {
                                minLeft = left;
                                minLen = right - left + 1;
                            }
                        }
                        map.put(leftChar, iCount + 1);
                    }
                    left++;
                }
            }
        }

        if (minLen > s.length()) {
            return "";
        }
        return s.substring(minLeft, minLeft + minLen);
    }
}
// @lc code=end

