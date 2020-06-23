import java.util.Stack;

/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
 */

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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i <= nums.length; i++) {
            TreeNode node = new TreeNode(i < nums.length ? nums[i] : Integer.MAX_VALUE);
            TreeNode left = null;
            while (!stack.isEmpty() && node.val >= stack.peek().val) {
                stack.peek().right = left;
                left = stack.pop();
            }
            node.left = left;
            stack.push(node);
        }
        return stack.pop().left;
    }
}
// @lc code=end

