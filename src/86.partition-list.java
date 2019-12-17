/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode left = leftHead;
        ListNode right = rightHead;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        head = dummyHead;
        while (head.next != null) {
            head = head.next;
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
        }
        left.next = rightHead.next;
        right.next = null;
        return leftHead.next;
    }
}
// @lc code=end

