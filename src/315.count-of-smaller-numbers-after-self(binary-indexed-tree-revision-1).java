import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(sorted[i], i);
        }
        int[] tree = new int[nums.length + 1];
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = map.get(nums[i]);
            res.addFirst(sum(tree, idx - 1));
            update(tree, idx);
        }
        return res;
    }
    private void update(int[] tree, int i) {
        i++;
        for (; i < tree.length; i += i & (-i)) {
            tree[i]++;
        }
    }
    private int sum(int[] tree, int i) {
        i++;
        int sum = 0;
        for (; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }

}
// @lc code=end

