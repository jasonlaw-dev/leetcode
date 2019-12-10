import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        combine(n, k, results, new LinkedList<>(), 1);
        return results;
    }

    public void combine(int n, int k, List<List<Integer>> results, LinkedList<Integer> currentList, int start) {
        if (currentList.size() == k) {
            results.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = start; i <= n - k + currentList.size() + 1; i++) {
            currentList.add(i);

            combine(n, k, results, currentList, i + 1);

            currentList.removeLast();
        }
    }
}
// @lc code=end

