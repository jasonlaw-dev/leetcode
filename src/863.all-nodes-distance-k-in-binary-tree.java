import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        parentMap.put(root, null);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.right != null) {
                stack.push(root.right);
                parentMap.put(root.right, root);
            }
            if (root.left != null) {
                stack.push(root.left);
                parentMap.put(root.left, root);
            }
        }
        Set<TreeNode> visited = new HashSet<>();
        dfs(target, K, visited, parentMap, res);
        return res;
    }
    private void dfs(TreeNode root, int K, Set<TreeNode> visited, Map<TreeNode, TreeNode> parentMap, List<Integer> res) {
        if (root == null) {
            return;
        }
        visited.add(root);
        if (K == 0) {
            res.add(root.val);
            return;
        }
        if (!visited.contains(root.left)) {
            dfs(root.left, K - 1, visited, parentMap, res);
        }
        if (!visited.contains(root.right)) {
            dfs(root.right, K - 1, visited, parentMap, res);
        }
        TreeNode parent = parentMap.get(root);
        if (parentMap != null && !visited.contains(parent)) {
            dfs(parent, K - 1, visited, parentMap, res);
        }
    }
}
// @lc code=end

