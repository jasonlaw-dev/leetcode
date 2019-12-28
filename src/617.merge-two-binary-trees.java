/*
 * @lc app=leetcode id=617 lang=java
 *
 * [617] Merge Two Binary Trees
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val = 0;
        TreeNode root;
        TreeNode other;
        if (t1 == null) {
            root = t2;
            other = t1;
            val += t2.val;
        } else {
            root = t1;
            other = t2;
            val += t1.val;
            if (t2 != null) {
                val += t2.val;
            }
        }
        root.val = val;
        root.left = mergeTrees(root.left, other == null ? null : other.left);
        root.right = mergeTrees(root.right, other == null ? null : other.right);
        return root;
    }
}
// @lc code=end

