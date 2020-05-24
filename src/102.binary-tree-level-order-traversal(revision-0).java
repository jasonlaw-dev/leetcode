import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        if (root != null) {
            q1.add(root);
            while (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    TreeNode node = q1.poll();
                    curr.add(node.val);
                    if (node.left != null) {
                        q2.add(node.left);
                    }
                    if (node.right != null) {
                        q2.add(node.right);
                    }
                }
                res.add(curr);
                curr = new ArrayList<>();
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }
        return res;
    }
}
// @lc code=end

