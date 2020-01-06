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

    Stack<TreeNode> stack = new Stack<>();
    TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
        TreeNode temp = stack.pop();
        root = temp.right;
        return temp.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return root != null || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

