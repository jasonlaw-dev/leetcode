/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root;
        TreeNode right = root;
        int height = -1;
        while (right != null) {
            right = right.right;
            left = left.left;
            height++;
        }
        if (left == null) {
            return (1 << (height + 1)) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
// @lc code=end

