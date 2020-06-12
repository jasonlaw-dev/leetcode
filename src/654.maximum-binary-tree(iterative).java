import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode curr = new TreeNode(num);
            while (!queue.isEmpty() && queue.peekLast().val < num) {
                curr.left = queue.pollLast();
            }
            if (!queue.isEmpty()) {
                queue.peekLast().right = curr;
            }
            queue.offerLast(curr);
        }
        return queue.pollFirst();
    }
}
// @lc code=end

