import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            count[c - 'a']++;
        }

        int idx = 0;
        int maxChar = S.charAt(0) - 'a';
        char[] res = new char[S.length()];

        for (int i = 0; i < 26; i++) {
            if (count[i] > count[maxChar]) {
                maxChar = i;
            }
        }

        if (count[maxChar] > (S.length() + 1) / 2) {
            return "";
        }

        while (count[maxChar] > 0) {
            res[idx] = (char) (maxChar + 'a');
            count[maxChar]--;
            idx += 2;
        }

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                count[i]--;
                idx += 2;
            }
        }

        return new String(res);
    }
}
// @lc code=end

