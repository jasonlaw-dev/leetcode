import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        combine(nums, results, new LinkedList<>(), 0);
        return results;
    }

    public void combine(int[] nums, List<List<Integer>> results, LinkedList<Integer> currentList, int start) {
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            currentList.add(nums[i]);
            results.add(new ArrayList<>(currentList));

            combine(nums, results, currentList, i + 1);
            currentList.removeLast();
        }
    }
}
// @lc code=end

