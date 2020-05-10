import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
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

    int maxCount = 0;
    
    Map<Integer, Integer> counts = new HashMap<>();
    
    List<Integer> res = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);

        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = res.get(i);
        return ans;
    }

    public int sum(TreeNode root) {
        if (root == null) return 0;
        int subtreeSum = root.val + sum(root.left) + sum(root.right);
        int newCount = counts.getOrDefault(subtreeSum, 0) + 1;
        if (newCount > maxCount) {
            maxCount = newCount;
            res = new ArrayList<>();
            res.add(subtreeSum);
        } else if (newCount == maxCount) {
            res.add(subtreeSum);
        }
        counts.put(subtreeSum, newCount);

        return subtreeSum;
    }
}
// @lc code=end

