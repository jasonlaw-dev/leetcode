/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 * 
 */

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

 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr != null && curr.next != null) {
            ListNode[] results = reverse(curr.next, k);
            if (results != null) {
                curr.next = results[0];
                curr = results[1];
            } else {
                curr = null;
            }
        }
        return dummyHead.next;
    }

    public ListNode[] reverse(ListNode head, int k) {
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            end = end.next;
            if (end == null && i < k - 1) {
                return null;
            }
        }
        ListNode previous = end;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return new ListNode[]{previous, tail};
    }
}
// @lc code=end

