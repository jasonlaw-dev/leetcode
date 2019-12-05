import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        bt(nums, visited, result, new ArrayList<>());
        return result;
    }

    public void bt(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempList.add(nums[i]);
                bt(nums, visited, result, tempList);
                tempList.remove(tempList.size() - 1);
                visited[i] = false;
            }
        }
    }
}
// @lc code=end

