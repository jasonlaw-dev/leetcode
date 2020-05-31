import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=842 lang=java
 *
 * [842] Split Array into Fibonacci Sequence
 */

// @lc code=start
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        split(S, 0, res);
        return res;
    }
    public boolean split(String S, int start, List<Integer> curr) {
        if (start == S.length()) {
            return curr.size() >= 3;
        }
        long temp = 0;
        for (int i = start; i < S.length(); i++) {
            temp = temp * 10 + (S.charAt(i) - '0');
            if (temp > Integer.MAX_VALUE) {
                break;
            }
            if (curr.size() < 2 || curr.get(curr.size() - 2) + curr.get(curr.size() - 1) == temp) {
                curr.add((int) temp);
                if (split(S, i + 1, curr)) {
                    return true;
                }
                curr.remove(curr.size() - 1);
            }
            if (temp == 0 || curr.size() >= 2 && curr.get(curr.size() - 2) + curr.get(curr.size() - 1) < temp) {
                break;
            }
        }
        return false;
    }
}
// @lc code=end

