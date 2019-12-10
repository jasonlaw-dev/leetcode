/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int len = Math.max(a.length(), b.length());
        for (int i = 0; i < len + carry; i++) {
            int sum = carry;
            if (i < a.length() && a.charAt(a.length() - i - 1) == '1') {
                sum++;
            }
            if (i < b.length() && b.charAt(b.length() - i - 1) == '1') {
                sum++;
            }
            carry = sum / 2;
            sb.append(sum % 2 == 0 ? '0' : '1');
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

