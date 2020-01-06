import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        List<Integer> currList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                currList.add(root.val);
                sum -= root.val;
                root = root.left;
            }
            root = stack.pop();
            if (!stack.isEmpty() && stack.peek() == root) {
                root = root.right;
            } else {
                if (root.left == null && root.right == null) {
                    if (sum == 0) {
                        results.add(new ArrayList<>(currList));
                    }
                }
                sum += root.val;
                currList.remove(currList.size() - 1);
                root = null;
            }
        }
        return results;
    }
}
// @lc code=end

