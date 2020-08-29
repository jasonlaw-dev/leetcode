import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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

class Element {
    TreeNode node;
    int pos;
    
    Element(TreeNode node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}

class Solution {
    Map<Integer, Integer> left = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Deque<Element> queue = new LinkedList<>();
        queue.add(new Element(root, 0));

        while (!queue.isEmpty()) {
            int left = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Element curr = queue.poll();
                if (i == 0) {
                    left = curr.pos;
                }
                if (curr.node.left != null) {
                    queue.offer(new Element(curr.node.left, curr.pos * 2));
                }
                if (curr.node.right != null) {
                    queue.offer(new Element(curr.node.right, curr.pos * 2 + 1));
                }
                max = Math.max(max, curr.pos - left + 1);
            }
        }
        return max;
    }
}
// @lc code=end

