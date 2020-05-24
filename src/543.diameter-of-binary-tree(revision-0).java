/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root != null) {
            dfs(root);
        }
        return max;
    }

    public int dfs(TreeNode root) {
        int treeDiameter = 0;
        int diameterFromRoot = 0;
        if (root.left != null) {
            int left = dfs(root.left);
            diameterFromRoot = 1 + left;
            treeDiameter = 1 + left;
        }
        if (root.right != null) {
            int right = dfs(root.right);
            diameterFromRoot = Math.max(diameterFromRoot, 1+right);
            treeDiameter += 1 + right;
        }
        max = Math.max(max, treeDiameter);
        return diameterFromRoot;
    }
}
// @lc code=end

