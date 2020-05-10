/*
 * @lc app=leetcode id=1038 lang=java
 *
 * [1038] Binary Search Tree to Greater Sum Tree
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
    public TreeNode bstToGst(TreeNode root) {
        gst(root, 0);
        return root;
    }
    private int gst(TreeNode root, int prevSum) {
        if (root == null) return prevSum;
        root.val += gst(root.right, prevSum);
        return gst(root.left, root.val);
    }
}
// @lc code=end

