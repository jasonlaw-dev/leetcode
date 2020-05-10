import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        return dfs(root, 0)[0];
    }

    public int[] dfs(TreeNode root, int depth) {
        if (root == null) {
            return null;
        }
        int[] left = dfs(root.left, depth + 1);
        int[] right = dfs(root.right, depth + 1);
        if (left == null && right == null) {
            return new int[]{root.val, depth};
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        if (right[1] > left[1]) {
            return right;
        }
        return left;
    }
}
// @lc code=end

