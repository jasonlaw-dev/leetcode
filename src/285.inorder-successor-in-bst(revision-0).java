/*
 * @lc app=leetcode id=285 lang=java
 *
 * [285] Inorder Successor in BST
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return find(root, p.val + 1);
    }
    private TreeNode find(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val > target) {
            TreeNode res = find(root.left, target);
            return res == null ? root : res;
        }
        if (root.val < target) {
            return find(root.right, target);
        }
        return root;
    }
}
// @lc code=end

