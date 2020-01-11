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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TreeNode> nullList = new ArrayList<>();
        nullList.add(null);
        ArrayList<TreeNode>[][] dp = new ArrayList[n][n];
        for (int size = 1; size <= n; size++) {
            for (int i = 0; i < n - size + 1; i++) {
                int j = i + size - 1;
                dp[i][j] = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    List<TreeNode> leftNodes = i <= k - 1 ? dp[i][k - 1] : nullList;
                    List<TreeNode> rightNodes = k + 1 <= j ? dp[k + 1][j] : nullList;
                    for (TreeNode left : leftNodes) {
                        for (TreeNode right : rightNodes) {
                            TreeNode root = new TreeNode(k + 1);
                            root.left = left;
                            root.right = right;
                            dp[i][j].add(root);
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
// @lc code=end

