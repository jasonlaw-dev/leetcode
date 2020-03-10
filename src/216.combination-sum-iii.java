import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 45) {
            bt(k, n, 1, res, new ArrayList<>());
        }
        return res;
    }

    public void bt(int k, int n, int startNum, List<List<Integer>> res, List<Integer> curr) {
        if (curr.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        if (startNum > 9 || n <= 0) return;
        for (int i = startNum; i <= 9; i++) {
            curr.add(i);
            bt(k, n - i, i + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end

