/*
 * @lc app=leetcode id=467 lang=java
 *
 * [467] Unique Substrings in Wraparound String
 */

// @lc code=start
class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int i = 0;
        int j = 0;
        int n = p.length();
        while (j < n) {
            while (j < n - 1 && (p.charAt(j) != 'z' ? p.charAt(j) + 1 == p.charAt(j + 1) : p.charAt(j + 1) == 'a')) {
                j++;
            }
            j++;
            // right now p[i, j) is valid
            for (int k = i; k < j && k - i < 26; k++) {
                int c = p.charAt(k) - 'a';
                count[c] = Math.max(count[c], j - k);
            }
            i = j;
        }
        int res = 0;
        for (int cnt : count) res += cnt;
        return res;
    }
}
// @lc code=end

