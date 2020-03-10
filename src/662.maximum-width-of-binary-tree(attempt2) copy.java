import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        preorder(root, 0, count);
        return max;
    }
    public void preorder(TreeNode root, int level, List<Integer> count) {
        if (root != null) {
            if (count.size() == level) {
                count.add(0);
            }
            count.set(level, count.get(level) + 1);
            max = Math.max(max, count.get(level));
            preorder(root.left, level + 1, count);
            preorder(root.right, level + 1, count);
        } else {
            int nullNodes = 1;
            for (int i = level; i < count.size(); i++) {
                count.set(i, count.get(i) + nullNodes);
                nullNodes *= 2;
            }
        }
    }
}
// @lc code=end

