import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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

class Item {
    TreeNode node;
    int depth;
    Item(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Item> stack = new Stack<>();
        stack.add(new Item(root, 0));
        while (!stack.isEmpty()) {
            Item item = stack.pop();
            if (res.size() == item.depth) {
                res.add(item.node.val);
            }
            if (item.node.left != null) {
                stack.push(new Item(item.node.left, item.depth + 1));
            }
            if (item.node.right != null) {
                stack.push(new Item(item.node.right, item.depth + 1));
            }
        }
        return res;
    }
}
// @lc code=end

