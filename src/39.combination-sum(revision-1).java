import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        bt(candidates, target, candidates.length - 1, res, new ArrayList<>());
        return res;
    }
    private void bt(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
        } else {
            for (int i = index; i >= 0; i--) {
                if (target - candidates[i] >= 0) {
                    curr.add(candidates[i]);
                    bt(candidates, target - candidates[i], i, res, curr);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}
// @lc code=end

