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
    private int height(TreeNode root) {
        if (root == null) return -1;
        int height = 0;
        while (root.left != null) {
            root = root.left;
            height++;
        }
        return height;
    }
    public int countNodes(TreeNode root) {
        int nodes = 0;
        int h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << (h - 1);
                root = root.left;
            }
            h--;
        }
        return nodes;
    }
}
// @lc code=end

