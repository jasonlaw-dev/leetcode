import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(inorder, postorder, inorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int postorderIndex, int start, int end) {
        if (postorderIndex < 0 || start > end) {
            return null;
        }
        int inorderIndex = inorderMap.get(postorder[postorderIndex]);
        TreeNode root = new TreeNode(postorder[postorderIndex]);
        root.right = build(inorder, postorder, postorderIndex - 1, inorderIndex + 1, end);
        root.left = build(inorder, postorder, postorderIndex - (end - inorderIndex) - 1, start, inorderIndex - 1);
        return root;
    }
}
// @lc code=end

