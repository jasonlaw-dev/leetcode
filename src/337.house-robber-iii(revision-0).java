/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
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
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    public int[] dfs(TreeNode root) {
        int[] result = {root.val, 0};
        if (root.left != null) {
            int[] left = dfs(root.left);
            result[0] += left[1];
            result[1] += Math.max(left[0], left[1]);
        }
        if (root.right != null) {
            int[] right = dfs(root.right);
            result[0] += right[1];
            result[1] += Math.max(right[0], right[1]);
        }
        return result;
    }

    // each dfs call should return an int[node used, node not used]
}
// @lc code=end

