import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(root, sum, results, new ArrayList<>());
        return results;
    }
    private void dfs(TreeNode root, int sum, List<List<Integer>> results, List<Integer> currList) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        currList.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                results.add(new ArrayList<>(currList));
            }
        } else {
            dfs(root.left, sum, results, currList);
            dfs(root.right, sum, results, currList);
        }
        currList.remove(currList.size() - 1);
    }
}
// @lc code=end

