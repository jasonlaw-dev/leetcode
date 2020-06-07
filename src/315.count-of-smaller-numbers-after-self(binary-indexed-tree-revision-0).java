import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start

class Node {
    int val;
    int index;
    Node(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(sortedNums[i], i);
        }

        int[] tree = new int[nums.length + 1];
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int sortedIndex = map.get(nums[i]);
            result.addFirst(getSum(tree,  sortedIndex - 1));
            update(tree, sortedIndex, 1);
        }
        return result;
    }
    int getSum(int[] tree, int index) {
        int sum = 0;
        for (int i = index + 1; i>0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }

    void update(int[] tree, int index, int delta) {
        for (int i = index + 1; i < tree.length; i += i & (-i)) {
            tree[i] += delta;
        }
    }

}
// @lc code=end

