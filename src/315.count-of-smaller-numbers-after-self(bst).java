import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class TreeNode {
    int val;
    int leftSum = 0;
    int count = 0;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] results = new Integer[nums.length];
        if (nums.length == 0) {
            return Arrays.asList(results);
        }
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        for (int i = nums.length - 1; i >= 0; i--) {
            TreeNode curr = root;
            int sum = 0;
            while (curr.val != nums[i]) {
                if (curr.val > nums[i]) {
                    curr.leftSum++;
                    if (curr.left == null) {
                        curr.left = new TreeNode(nums[i]);
                    }
                    curr = curr.left;
                } else {
                    sum += curr.leftSum + curr.count;
                    if (curr.right == null) {
                        curr.right = new TreeNode(nums[i]);
                    }
                    curr = curr.right;
                }
            }
            curr.count++;
            results[i] = sum + curr.leftSum;
        }
        return Arrays.asList(results);
    }
}
// @lc code=end

