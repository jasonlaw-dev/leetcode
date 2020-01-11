import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    List<TreeNode> nullList = new ArrayList<>();
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        nullList.add(null);
        ArrayList<TreeNode>[][] memo = new ArrayList[n][n];
        return generateTrees(memo, 0, n - 1);
    }
    public List<TreeNode> generateTrees(ArrayList<TreeNode>[][] memo, int start, int end) {
        if (start > end) {
            return nullList;
        }
        if (memo[start][end] == null) {
            memo[start][end] = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftNodes = generateTrees(memo, start, i - 1);
                List<TreeNode> rightNodes = generateTrees(memo, i + 1, end);
                for (TreeNode left : leftNodes) {
                    for (TreeNode right : rightNodes) {
                        TreeNode root = new TreeNode(i + 1);
                        root.left = left;
                        root.right = right;
                        memo[start][end].add(root);
                    }
                }
            }
        }
        return memo[start][end];
    }
}
// @lc code=end

