import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, sum, 0 , map);
    }

    public int dfs(TreeNode root, int target, int prevSum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int currSum = prevSum + root.val;
        int count = map.getOrDefault(currSum - target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        count += dfs(root.left, target, currSum, map);
        count += dfs(root.right, target, currSum, map);
        map.put(currSum, map.getOrDefault(currSum, 0) - 1);
        return count;
    }
}
// @lc code=end

