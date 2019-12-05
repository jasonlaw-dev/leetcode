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
        if (nums.length == 0) {
            return result;
        }
        int perms = 1;
        for (int i = 2; i <= nums.length; i++) {
            perms *= i;
        }
        for (int i = 0; i < perms; i++) {
            result.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[perms];
        bt(nums, visited, result, 0, perms, 0);
        return result;
    }

    public void bt(int[] nums, boolean[] visited, List<List<Integer>> result, int start, int len, int index) {
        if (index == nums.length) {
            return;
        }
        int repeat = len / (nums.length - index);
        int numFilled = 0;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            for (int j = 0; j < repeat; j++) {
                result.get(start + numFilled * repeat + j).add(nums[i]);
            }
            visited[i] = true;
            bt(nums, visited, result, start + numFilled * repeat, repeat, index + 1);
            visited[i] = false;
            numFilled++;
        }
    }
}
// @lc code=end

