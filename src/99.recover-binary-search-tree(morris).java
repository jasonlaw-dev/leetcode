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
    TreeNode temp = null;
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {

        while (root != null) {
            if (root.left == null) {
                checkNode(root);
                root = root.right;
            } else {
                temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    temp.right = null;
                    checkNode(root);
                    root = root.right;
                }
            }
        }
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
    public void checkNode(TreeNode node) {
        if (prev != null && node.val <= prev.val) {
            if (first == null) {
                first = prev;
                second = node;
            } else {
                second = node;
            }
        }
        prev = node;
    }
}
// @lc code=end

