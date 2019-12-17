/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

public class TreeNode {
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        } else if (!(root.left != null && root.right != null)) {
            return false;
        }
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        leftStack.push(root.left);
        rightStack.push(root.right);
        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            if (leftStack.isEmpty() || rightStack.isEmpty()) {
                return false;
            }
            TreeNode left = leftStack.pop();
            TreeNode right = rightStack.pop();
            if (left.val != right.val) {
                return false;
            }
            if (!(left.left == null && right.right == null)) {
                if (left.left == null || right.right == null) {
                    return false;
                } else {
                    leftStack.push(left.left);
                    rightStack.push(right.right);
                }
            }
            if (!(right.left == null && left.right == null)) {
                if (right.left == null || left.right == null) {
                    return false;
                } else {
                    leftStack.push(right.left);
                    rightStack.push(left.right);
                }
            }
        }
        return true;
    }
}
// @lc code=end

