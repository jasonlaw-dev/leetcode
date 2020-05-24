import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 * 
 * NOTE: array is not sorted
 */

// @lc code=start
class Solution {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(candidates, target, 0, new ArrayList<>(), 0);
        return results;
    }

    public void bt(int[] candidates, int target, int startIndex, List<Integer> combinations, int currSum) {
        for (int i = startIndex; i < candidates.length; i++) {
            int sum = currSum + candidates[i];
            combinations.add(candidates[i]);
            if (sum < target) {
                bt(candidates, target, i, combinations, sum);
            } else if (sum == target) {
                this.results.add(new ArrayList<>(combinations));
            }
            combinations.remove(combinations.size() - 1);
            if (sum >= target) {
                return;
            }
        }
    }
}
// @lc code=end

