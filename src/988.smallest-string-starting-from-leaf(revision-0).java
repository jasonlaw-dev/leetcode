/*
 * @lc app=leetcode id=988 lang=java
 *
 * [988] Smallest String Starting From Leaf
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
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
    public String dfs(TreeNode root, String suffix) {
        if (root == null) {
            return suffix;
        }
        suffix = (char)(root.val + 'a') + suffix;
        if (root.left == null && root.right == null) {
            return suffix;
        }
        if (root.left == null || root.right == null) {
            return root.left == null ? dfs(root.right, suffix) : dfs(root.left, suffix);
        }
        String left = dfs(root.left, suffix);
        String right = dfs(root.right, suffix);
        return left.compareTo(right) <= 0 ? left : right;
    }
}
// @lc code=end

