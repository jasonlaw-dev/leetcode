/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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


 //  1->2->3->4->5
 // SLOW: 0, FAST: 0
 // SLOW: 1, FAST: 2
 // SLOW 2, FAST 4
 // 1->2->3->4->6

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        if (fastNode == null) {
            return slowNode.next;
        }
        while (fastNode != null) {
            fastNode = fastNode.next;
            if (fastNode != null) {
                slowNode = slowNode.next;
            }
        }

        // 1 -> 2 -> 3,  n =2

        ListNode nodeAfterRemove = slowNode.next != null ? slowNode.next.next : null;
        slowNode.next = nodeAfterRemove;
        return head;
    }
}
// @lc code=end

