/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
    public void flatten(TreeNode root) {
        if (root != null) {
            helper(root);
        }
    }

    TreeNode helper(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode lastNode = null;
        if (left != null) {
            root.left = null;
            root.right = left;
            lastNode = helper(left);
            lastNode.right = right;
        }
        return right == null ? (lastNode != null ? lastNode : root) : helper(right);
    }
}
// @lc code=end

