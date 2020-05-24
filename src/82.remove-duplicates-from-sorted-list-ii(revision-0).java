/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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

 // null
 // 1 1
 // 1 2 2 3
 // 1 2 3 3
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prevGoodNode = dummyHead;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head = head.next;
                while (head.next != null && head.next.val == head.val) {
                    head = head.next;
                }
                prevGoodNode.next = head.next;
                head = prevGoodNode.next;
            } else {
                prevGoodNode = head;
                head = head.next;
            }
        }
        return dummyHead.next;
    }
}
// @lc code=end

