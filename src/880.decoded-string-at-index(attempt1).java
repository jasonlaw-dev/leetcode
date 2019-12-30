/*
 * @lc app=leetcode id=880 lang=java
 *
 * [880] Decoded String at Index
 */

// @lc code=start
class Solution {
    public String decodeAtIndex(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c >= '0' && c <= '9') {
                int repeat = c - '0';
                if (K <= sb.length() * repeat) {
                    return sb.charAt((K - 1) % sb.length()) + "";
                } else {
                    String curr = sb.toString();
                    for (; repeat > 1; repeat--) {
                        sb.append(curr);
                    }
                }
            } else {
                sb.append(c);
                if (K == sb.length()) {
                    return sb.charAt(K - 1) + "";
                }
            }
        }
        return null;
    }
}
// @lc code=end

