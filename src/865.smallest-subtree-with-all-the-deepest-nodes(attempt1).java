import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=865 lang=java
 *
 * [865] Smallest Subtree with all the Deepest Nodes
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
    int deepest = -1;
    TreeNode deepLeft = null;
    TreeNode deepRight = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<Integer, TreeNode> parent = new HashMap<>();
        dfs(root, 0, parent);
        while (deepLeft != deepRight) {
            deepLeft = parent.get(deepLeft.val);
            deepRight = parent.get(deepRight.val);
        }
        return deepLeft;
    }

    private void dfs(TreeNode root, int depth, Map<Integer, TreeNode> parent) {
        if (root.left == null && root.right == null) {
            if (depth > deepest) {
                deepest = depth;
                deepLeft = root; 
                deepRight = root;
            } else if (depth == deepest) {
                deepRight = root;
            }
            return;
        }
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left, depth + 1, parent);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right, depth + 1, parent);
        }
    }
    
}
// @lc code=end

