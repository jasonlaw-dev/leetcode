/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) {
            return "0";
        }
        int integerPart = numerator / denominator;
        int zeros = -1;
        int fractionalPart = 0;
        boolean isRecurring = false;
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        boolean isEven = true;
        int divisor = 10;
        while (numerator % denominator != 0) {
            numerator *= 10;
            if (numerator >= denominator) {
                isEven = !isEven;
                if (isEven) {
                    int div = numerator / denominator;
                    if (div / divisor == div % divisor) {
                        fractionalPart = div % divisor;
                        isRecurring = true;
                        break;
                    }
                    divisor *= 10;
                }
            } else {
                zeros ++;
            }
            numerator *= 10;
            fractionalPart = numerator / denominator;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(integerPart);
        if (fractionalPart > 0) {
            sb.append('.');
            for (int i = 0; i < zeros; i++) {
                sb.append('0');
            }
            if (isRecurring) {
                sb.append("(" + fractionalPart + ")");
            } else {
                sb.append(fractionalPart);
            }
            
        }
        return sb.toString();
    }
}
// @lc code=end

