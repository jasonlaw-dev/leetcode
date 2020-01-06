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
        flatten(root, null);
    }

    private TreeNode flatten(TreeNode root, TreeNode pre) {
        if(root==null) return pre;
        pre=flatten(root.right,pre);    
        pre=flatten(root.left,pre);
        root.right=pre;
        root.left=null;
        return root;
    }
}
// @lc code=end

