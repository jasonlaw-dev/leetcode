import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        int curr = 0;
        for (char c : input.toCharArray()) {
            if (c >= '0' && c <= '9') {
                curr = curr * 10 + (c - '0');
            } else {
                numbers.add(curr);
                curr = 0;
                operators.add(c);
            }
        }
        numbers.add(curr);
        ArrayList<Integer>[][] memo = new ArrayList[numbers.size()][numbers.size()];
        return eval(numbers, operators, 0, numbers.size() - 1, memo);
    }
    private List<Integer> eval(List<Integer> numbers, List<Character> operators, int start, int end, ArrayList<Integer>[][] memo) {
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (start == end) {
            res.add(numbers.get(start));
        } else {
            for (int i = start; i < end; i++) {
                char op = operators.get(i);
                List<Integer> leftRes = eval(numbers, operators, start, i, memo);
                List<Integer> rightRes = eval(numbers, operators, i + 1, end, memo);
                for (int left : leftRes) {
                    for (int right : rightRes) {
                        int val = 0;
                        if (op == '+') {
                            val = left + right;
                        } else if (op == '-') {
                            val = left - right;
                        } else if (op == '*') {
                            val = left * right;
                        }
                        res.add(val);
                    }
                }
            }
        }
        memo[start][end] = res;
        return res;
    }
}
// @lc code=end

