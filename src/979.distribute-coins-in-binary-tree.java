/*
 * @lc app=leetcode id=979 lang=java
 *
 * [979] Distribute Coins in Binary Tree
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
    public int distributeCoins(TreeNode root) {
        return dist(root)[1];
    }
    public int[] dist(TreeNode root) {
        int net = root.val - 1;
        int moves = 0;
        if (root.left != null) {
            int[] left = dist(root.left);
            net += left[0];
            moves += left[1];
        }
        if (root.right != null) {
            int[] right = dist(root.right);
            net += right[0];
            moves += right[1];
        }
        moves += Math.abs(net);
        return new int[]{net, moves};
    }
}
// @lc code=end

