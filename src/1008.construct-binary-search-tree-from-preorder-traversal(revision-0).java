/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
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
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode bst(int[] preorder, int min, int max) {
        if (i >= preorder.length || preorder[i] < min || preorder[i] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        i++;
        root.left = bst(preorder, min, root.val - 1);
        root.right = bst(preorder, root.val + 1, max);
        return root;
    }
}
// @lc code=end

