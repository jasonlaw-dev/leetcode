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
        return construct(nums, 0, nums.length - 1);
    }
    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end) return null;
        int max = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = construct(nums, start, max - 1);
        root.right = construct(nums, max + 1, end);
        return root;
    }
}
// @lc code=end

