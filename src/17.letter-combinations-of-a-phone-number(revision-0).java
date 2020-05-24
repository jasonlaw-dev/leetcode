import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 * 
 *  NOTE: so many careless mistakes, remember there is pqrs!
 *  Try DFS next time
 */

// @lc code=start
class Solution {
    static char[] digitMap = new char[]{'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits.length() > 0) {
            char[] str = new char[digits.length()];

            for (int i = 0; i < digits.length(); i++) {
                str[i] = digitMap[digits.charAt(i) - '2'];
            }
            
            while (true) {
                results.add(new String(str));
                boolean overflow = false;
                int i = str.length - 1;
                do {
                    char currentChar = str[i];
                    str[i] = getNextChar(currentChar, digits.charAt(i));
                    overflow = str[i] < currentChar;
                    if (overflow) {
                        i--;
                    }
                } while (overflow && i >= 0);
                if (overflow && i < 0) {
                    break;
                }
            }
        }
        return results;
    }
    char getNextChar(char c, char digit) {
        int digitIndex = digit - '2';
        if (digitIndex >= digitMap.length - 1) {
            if (c == 'z') {
                return 'w';
            }
        } else if (c + 1 == (int)(digitMap[digitIndex + 1])) {
            return digitMap[digitIndex];
        }
        return (char)(c + 1);
    }
}
// @lc code=end

