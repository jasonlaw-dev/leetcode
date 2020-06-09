import java.util.Arrays;

/*
 * @lc app=leetcode id=738 lang=java
 *
 * [738] Monotone Increasing Digits
 * 
 * 1222: since 1110 < 1111, use the greatest monotone, 999
 * 
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int N) {
        int k = 1;
        for (int temp = N / 10; temp > 0; temp /= 10) {
            k *= 10;
        }
        int maxDigit = N / k;
        int firstOcc = k;
        for (; k > 0; k /= 10) {
            int currDigit = (N / k) % 10;
            if (currDigit < maxDigit) {
                break;
            }
            if (currDigit > maxDigit) {
                firstOcc = k;
                maxDigit = currDigit;
            }
        }
        if (k == 0) {
            return N;
        }
        return N - (N % firstOcc) - 1;
    }
}
// @lc code=end

