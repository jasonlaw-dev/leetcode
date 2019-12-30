/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Result {
    String s;
    int index;
    Result(String s, int index) {
        this.s = s;
        this.index = index;
    }
}
class Solution {
    public String decodeString(String s) {
        return decode(s, 0).s;
    }

    private Result decode(String s, int i) {
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c >= '0' && c <= '9') {
                int sum = 0;
                do {
                    char n = s.charAt(i);
                    sum *= 10; // be careful here
                    sum += (n - '0');
                    i++;
                } while (s.charAt(i) >= '0' && s.charAt(i) <= '9');
                // at this point, i should be at [
                i++; // start decoding from the index after open bracket
                Result res = decode(s, i);
                for (; sum > 0; sum--) {
                    sb.append(res.s);
                }
                i = res.index; // at close bracket
            } else if (c == ']') {
                break;
            }
            i++;
        }
        return new Result(sb.toString(), i);
    }
}
// @lc code=end

