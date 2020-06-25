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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode node = root;
        int left = 0;
        int right = 0;
        while (node != null) {
            left++;
            node = node.left;
        }
        node = root;
        while (node != null) {
            right++;
            node = node.right;
        }
        if (left == right) {
            return (1 << (left)) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
// @lc code=end

