import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=894 lang=java
 *
 * [894] All Possible Full Binary Trees
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
    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0) {
            return new ArrayList<>();
        }
        List<List<TreeNode>> dp = new ArrayList<>();
        dp.add(Arrays.asList(new TreeNode(0)));
        for (int i = 1; i <= N / 2; i++) {
            List<TreeNode> curr = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<TreeNode> leftNodes = dp.get(j);
                List<TreeNode> rightNodes = dp.get(i - 1 - j);
                for (TreeNode left : leftNodes) {
                    for (TreeNode right : rightNodes) {
                        TreeNode parent = new TreeNode(0);
                        parent.left = left;
                        parent.right = right;
                        curr.add(parent);
                    }
                }
            }
            dp.add(curr);
        }
        return dp.get(N/2);
    }
}
// @lc code=end

