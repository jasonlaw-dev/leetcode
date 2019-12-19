import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, int[] inorder, int preorderIndex, int start, int end) {
        if (preorderIndex >= preorder.length || start > end) {
            return null;
        }
        int inorderIndex = inorderMap.get(preorder[preorderIndex]);
        TreeNode root = new TreeNode(preorder[preorderIndex]);
        root.left = build(preorder, inorder, preorderIndex + 1, start, inorderIndex - 1);
        root.right = build(preorder, inorder, preorderIndex + (inorderIndex - start) + 1, inorderIndex + 1, end);
        return root;
    }
}
// @lc code=end

