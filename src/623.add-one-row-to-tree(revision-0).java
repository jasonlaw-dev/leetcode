/*
 * @lc app=leetcode id=623 lang=java
 *
 * [623] Add One Row to Tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        return add(root, v, d, true);
    }
    public TreeNode add(TreeNode root, int v, int d, boolean isLeft) {
        if (d == 1) {
            return new TreeNode(v, isLeft ? root : null, isLeft ? null : root);
        }
        if (root == null) {
            return null;
        }
        root.left = add(root.left, v, d - 1, true);
        root.right = add(root.right, v, d - 1, false);
        return root;
    }
}
// @lc code=end

