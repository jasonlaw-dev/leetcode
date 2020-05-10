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

class Element {
    TreeNode node;
    int depth;
    Element(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}


class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root, 0).node;
    }

    private Element dfs(TreeNode root, int depth) {
        if (root == null) {
            return new Element(null, depth - 1);
        }
        Element l = dfs(root.left, depth + 1);
        Element r = dfs(root.right, depth + 1);

        if (l.depth == r.depth) {
            return new Element(root, l.depth); 
        }
        
        return l.depth > r.depth ? l : r;
    }
}
// @lc code=end

