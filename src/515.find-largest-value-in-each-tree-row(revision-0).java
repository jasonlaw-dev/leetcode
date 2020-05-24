import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    
    public void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (depth < res.size()) {
            if (root.val > res.get(depth)) {
                res.set(depth, root.val);
            }
        } else {
            res.add(root.val);
        }
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }
}
// @lc code=end

