/*
 * @lc app=leetcode id=968 lang=java
 *
 * [968] Binary Tree Cameras
 * 
 * [parent has cam, parent has no camera]
 * 
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
    public int minCameraCover(TreeNode root) {
        return minCamera(root)[0];
    }
    // [parent has no cam, parent has cam, root has cam]
    public int[] minCamera(TreeNode root) {
        if (root == null) return new int[]{0,0,0};
        int[] left = minCamera(root.left);
        int[] right = minCamera(root.right);

        int[] res = new int[3];
        res[2] = 1 + left[1] + right[1];
        res[1] = Math.min(res[2], left[0] + right[0]);
        res[0] = res[2];
        if (root.left != null) {
            res[0] = Math.min(res[0], left[2] + right[0]);
        }
        if (root.right != null) {
            res[0] = Math.min(res[0], right[2] + left[0]);
        }
        return res;
    }
}
// @lc code=end

