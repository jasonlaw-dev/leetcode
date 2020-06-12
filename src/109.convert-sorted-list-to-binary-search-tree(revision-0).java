/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return sort(head, null);
    }
    public TreeNode sort(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        // System.out.println("Start: " +start.val + " end: " + (end == null ? "null" : end.val));
        if (start.next == end) {
            return new TreeNode(start.val);
        }
        // System.out.println("passed");

        ListNode fast = start;
        ListNode slow = start;
        while (fast.next != end && fast.next.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println("Slow: " +slow.val);

        TreeNode root = new TreeNode(slow.val);
        root.left = sort(start, slow);
        root.right = sort(slow.next, end);
        return root;
    }
}
// @lc code=end

