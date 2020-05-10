/*
 * @lc app=leetcode id=701 lang=java
 *
 * [701] Insert into a Binary Search Tree
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curr = root;
        TreeNode parent = null;
        while (curr != null) {
            parent = curr;
            if (curr.val > val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (parent != null) {
            if (parent.val > val) {
                parent.left = new TreeNode(val);
            } else {
                parent.right = new TreeNode(val);
            }
            return root;
        }
        return new TreeNode(val);
    }
}
// @lc code=end

