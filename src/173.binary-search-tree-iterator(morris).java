import java.util.Stack;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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
class BSTIterator {

    TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        while (root != null) {
            if (root.left == null) {
                int val = root.val;
                root = root.right;
                return val;
            } else {
                TreeNode temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    temp.right = null;
                    int val = root.val;
                    root = root.right;
                    return val;
                }
            }
        }
        return Integer.MIN_VALUE;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.root != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

