/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode prev = dummyHead;
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }
        
        ListNode tailEnd = prev.next;
        head = tailEnd.next;
        for (int i = 0; i < n - m; i++) {
            tailEnd.next = head.next;
            head.next = prev.next;
            prev.next = head;
            head = tailEnd.next;
        }

        return dummyHead.next;
    }
}
// @lc code=end

