import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            results.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return results;
    }
}
// @lc code=end

