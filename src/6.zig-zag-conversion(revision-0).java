/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 * 
 *  NOTE: be careful about indices, don't guess, do more test cases to confirm whether this is correct
 */

// 0     6    N
// 1   5 7  I G
// 2 4   8 R
// 3     9

// 0       8    N
// 1     7 9  I G
// 2   6   10 R
// 3 5     11
// 4       12


// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // groupLength = numRows + numRows - 2
        // first row: 0, groupLength, groupLength * 2, ...
        // 2nd to n-1 row:
        // last row: numRows - 1, numRows - 1 + groupLength, numRows - 1 + groupLength * 2

        StringBuilder sb = new StringBuilder(s.length());
        int groupLength = numRows * 2 - 2;
        for (int i = 0; i < s.length(); i += groupLength) {
            sb.append(s.charAt(i));
        }
        for (int rowIndex = 1; rowIndex < numRows - 1; rowIndex++) {
            int vertical = rowIndex;
            int diagonal = numRows * 2 - rowIndex - 2;
            while (true) {
                if (vertical >= s.length()) {
                    break;
                }
                sb.append(s.charAt(vertical));
                if (diagonal >= s.length()) {
                    break;
                }
                sb.append(s.charAt(diagonal));
                vertical += groupLength;
                diagonal += groupLength;
            }
        } 
        for (int i = numRows - 1; i < s.length(); i += groupLength) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
// @lc code=end

