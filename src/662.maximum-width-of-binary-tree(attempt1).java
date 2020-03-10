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
    public int widthOfBinaryTree(TreeNode root) {
        List<TreeNode> curr = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        if (root == null) return 0;
        curr.add(root);
        int max = 1;
        while (!curr.isEmpty()) {
            int nullCount = 0;
            for (int i = 0; i < curr.size(); i++) {
                TreeNode node = curr.get(i);
                if (node != null) {
                    for (int j = 0; j <= 1; j++) {
                        TreeNode child = j == 0 ? node.left : node.right;
                        if (child != null) {
                            for (; nullCount > 0; nullCount--) {
                                next.add(null);
                            }
                            next.add(child);
                        } else {
                            if (!next.isEmpty()) {
                                nullCount++;
                            }
                        }
                    }
                } else {
                    if (!next.isEmpty()) {
                        nullCount += 2;
                    }
                }
            }
            max = Math.max(max, next.size());
            curr = next;
            next = new ArrayList<>();
        }
        return max;
    }
}
// @lc code=end

