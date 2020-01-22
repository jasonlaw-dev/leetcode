/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // when even
        // fast.next == null, slow would be at the end of slow list.
        // when odd
        // fast.next.next == null, slow would be at 2nd last.
        if (fast.next != null) {
            slow = slow.next;
        }
        // slow would be at end of list.

        fast = slow.next;
        slow.next = null;

        ListNode tail = null;
        while (fast != null) {
            ListNode next = fast.next;
            fast.next = tail;
            tail = fast;
            fast = next;
        }
        // System.out.println(tail.val);
        while (tail != null) {
            ListNode next = head.next;
            head.next = tail;
            tail = tail.next;
            head.next.next = next;
            head = next;
        }
    }
}
// @lc code=end

