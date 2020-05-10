/*
 * @lc app=leetcode id=958 lang=java
 *
 * [958] Check Completeness of a Binary Tree
 */

/*
1
2 3
4 5 6 7
8 9  10 11  12 13 null null
15
*/

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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != null;
    }

    private int[] dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[] {0,0};
        }
        if (root.left == null) return null;
        int[] left = dfs(root.left);
        if (left == null) return null;

        if (root.right == null) {
            if (left[1] == 0) {
                return new int[]{0, 1};
            }
        } else {
            int[] right = dfs(root.right);
            if (right == null) return null;
            if (left[0] == left[1] && (left[0] == right[1] || left[0] - 1 == right[1])
                || left[0] != left[1] && left[0] == right[0] && left[0] == right[1]
            ) {
                return new int[]{ right[0] + 1, left[1] + 1 };
            }
        }
        return null;
    }
}
// @lc code=end

