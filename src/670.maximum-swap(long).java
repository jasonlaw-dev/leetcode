import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        int[] digits = new int[9];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        int[] prevMax = new int[9];
        Arrays.fill(prevMax, -1);

        int maxIndex = 0;
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] < digits[maxIndex]) {
                prevMax[i] = maxIndex;
            } else if (digits[i] > digits[maxIndex]) {
                maxIndex = i;
            }
        }
        int i = digits.length - 1;
        while (digits[i] == 0) i--;
        for (; i > 0; i--) {
            if (prevMax[i] >= 0) {
                int tmp = digits[i];
                digits[i] = digits[prevMax[i]];
                digits[prevMax[i]] = tmp;
                break;
            }
        }

        int mul = 1;
        int res = 0;
        for (i = 0; i < digits.length; i++) {
            res += digits[i] * mul;
            mul *= 10;
        }
        return res;
    }
}
// @lc code=end

