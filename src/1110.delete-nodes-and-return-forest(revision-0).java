import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 * 
 * maintain boolean[] of 1001 length
 * 
 * preorder approach
 * 
 * at each recursive call
 * check whether we should insert the current node by checking if it should be deleted
 * if not, insert if it does not have a parent
 * then recursively call its child
 * 
 * what to return? return null if curr is null || the node needs to deleted, otherwise return node
 * root.left = dfs(root.left)
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        boolean[] delete = new boolean[1001];
        for (int d : to_delete) {
            delete[d] = true;
        }
        List<TreeNode> res = new ArrayList<>();
        dfs(root, null, delete, res);
        return res;
    }

    public TreeNode dfs(TreeNode root, TreeNode parent, boolean[] delete, List<TreeNode> res) {
        if (root == null) {
            return null;
        }
        TreeNode curr = root;
        if (delete[root.val]) {
            curr = null;
        } else if (parent == null) {
            res.add(root);
        }
        root.left = dfs(root.left, curr, delete, res);
        root.right = dfs(root.right, curr, delete, res);
        return curr;
    }
}
// @lc code=end

