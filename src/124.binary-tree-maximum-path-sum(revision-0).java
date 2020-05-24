/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return max;
    }

    public Integer pathSum(TreeNode root) {
        if (root == null) {
            return null;
        }
        int maxPathFromRoot = root.val;
        max = Math.max(max, root.val);
        Integer leftMax = pathSum(root.left);
        Integer rightMax = pathSum(root.right);
        if (leftMax != null) {
            maxPathFromRoot = Math.max(maxPathFromRoot, root.val + leftMax);
            max = Math.max(max, leftMax);
            max = Math.max(max, root.val + leftMax);
        }
        if (rightMax != null) {
            maxPathFromRoot = Math.max(maxPathFromRoot, root.val + rightMax);
            max = Math.max(max, rightMax);
            max = Math.max(max, root.val + rightMax);
        }
        if (leftMax != null && rightMax != null) {
            max = Math.max(max, root.val + leftMax + rightMax);
        }
        return maxPathFromRoot;
    }
}
// @lc code=end

