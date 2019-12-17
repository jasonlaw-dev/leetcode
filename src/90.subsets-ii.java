import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> results = new ArrayList<>();
        subsets(nums, results, new LinkedList<>(), visited, 0);
        return results;
    }

    public void subsets(int[] nums, List<List<Integer>> results, LinkedList<Integer> list, boolean[] visited, int startIndex) {
        results.add(new ArrayList<>(list));
        for (int i = startIndex; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i] || visited[i-1]) {
                visited[i] = true;
                list.add(nums[i]);
                subsets(nums, results, list, visited, i + 1);
                list.removeLast();
                visited[i] = false;
            }
        }
    }
}
// @lc code=end

