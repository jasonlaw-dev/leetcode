/*
 * @lc app=leetcode id=848 lang=java
 *
 * [848] Shifting Letters
 */

// @lc code=start
class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        char[] str = S.toCharArray();
        int shift = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            str[i] = (char) (str[i] + shift);
            if (str[i] > 'z') {
                str[i] -= 26;
            }
        }
        return new String(str);

    }
}
// @lc code=end

