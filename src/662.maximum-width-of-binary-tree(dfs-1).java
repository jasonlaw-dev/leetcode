import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    Map<Integer, Integer> left = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return max;
    }
    public void dfs(TreeNode root, int depth, int pos) {
        if (root != null) {
            left.computeIfAbsent(depth, x -> pos);
            max = Math.max(max, pos - left.get(depth) + 1);
            dfs(root.left, depth + 1, pos * 2);
            dfs(root.right, depth + 1, pos * 2 + 1);
        }
    }
}
// @lc code=end

