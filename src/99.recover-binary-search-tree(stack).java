import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prevNode = null;
        TreeNode mistake1 = null;
        TreeNode mistake2 = null;
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prevNode != null && prevNode.val >= curr.val) {
                mistake2 = curr;
                if (mistake1 == null) {
                    mistake1 = prevNode;
                } else {
                    break;
                }
            }
            prevNode = curr;
            curr = curr.right;
        }
        int temp = mistake1.val;
        mistake1.val = mistake2.val;
        mistake2.val = temp;
    }
}
// @lc code=end

