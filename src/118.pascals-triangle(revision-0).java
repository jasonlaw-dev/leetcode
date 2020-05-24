import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) {
            return res;
        }
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for (int row = 1; row < numRows; row++) {
            List<Integer> prevList = res.get(row - 1);
            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i <= row; i++) {
                int sum = 0;
                if (i - 1 >= 0) {
                    sum += prevList.get(i - 1);
                }
                if (i < row) {
                    sum += prevList.get(i);
                }
                currList.add(sum);
            }
            res.add(currList);
        }
        return res;
    }
}
// @lc code=end

