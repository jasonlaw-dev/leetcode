import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        bt(nums, 0, results, new ArrayList<>());
        return results;
    }

    private void bt(int[] nums, int start, List<List<Integer>> results, List<Integer> curr) {
        if (curr.size() >= 2) {
            results.add(new ArrayList<>(curr));
        }
        if (start == nums.length) return;
        boolean[] visited = new boolean[201];
        int prev = curr.isEmpty() ? - 101 : curr.get(curr.size() - 1);
        for (int i = start; i < nums.length; i++) {
            if (nums[i] >= prev && !visited[nums[i] + 100]) {
                curr.add(nums[i]);
                bt(nums, i + 1, results, curr);
                curr.remove(curr.size() - 1);
                visited[nums[i] + 100] = true;
            }
        }
    }
}
// @lc code=end

