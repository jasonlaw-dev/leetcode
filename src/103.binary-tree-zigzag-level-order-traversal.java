import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 */

public class TreeNode {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root == null) {
            return res;
        }
        list.add(root);
        boolean isLeft = true;
        while (!list.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelNodes = list.size();
            for (int i = 0; i < levelNodes; i++) {
                if (isLeft) {
                    TreeNode node = list.pollFirst();
                    level.add(node.val);
                    if (node.left != null) {
                        list.addLast(node.left);
                    }
                    if (node.right != null) {
                        list.addLast(node.right);
                    }
                } else {
                    TreeNode node = list.pollLast();
                    level.add(node.val);
                    if (node.right != null) {
                        list.addFirst(node.right);
                    }
                    if (node.left != null) {
                        list.addFirst(node.left);
                    }
                }
            }
            isLeft = !isLeft;
            res.add(level);
        }
        return res;
    }
}
// @lc code=end

