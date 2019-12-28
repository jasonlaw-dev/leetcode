/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }
    public int dfs(TreeNode root) {
        if (root.left != null) {
            int val = dfs(root.left);
            if (this.k <= 0) {
                return val;
            }
        }
        this.k--;
        if (this.k == 0) {
            return root.val;
        }
        if (root.right != null) {
            int val = dfs(root.right);
            if (this.k <= 0) {
                return val;
            }
        }
        return 0;
    }
    
}
// @lc code=end

