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
        char[] str = (num + "").toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < str.length; i++) {
            last[str[i] - '0'] = i;
        }
        for (int i = 0; i < str.length; i++) {
            for (int k = 9; k > str[i] - '0'; k--) {
                if (last[k] > i) {
                    char tmp = str[i];
                    str[i] = str[last[k]];
                    str[last[k]] = tmp;
                    return Integer.parseInt(new String(str));
                }
            }
        }
        return num;
    }
}
// @lc code=end

