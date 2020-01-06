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
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    temp.right = root.right;
                    root.right = root.left;
                    root.left = null;
                    root = temp.right;
                }
            }
        }
    }
}
// @lc code=end

