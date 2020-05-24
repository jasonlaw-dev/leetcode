/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode oddCurr = oddHead;
        ListNode evenCurr = evenHead;
        for (int i = 1; head != null; i++) {
            if (i % 2 == 1) {
                oddCurr.next = head;
                oddCurr = head;
            } else {
                evenCurr.next = head;
                evenCurr = head;
            }
            head = head.next;
        }
        evenCurr.next = null;
        oddCurr.next = evenHead.next;
        return oddHead.next;
    }
}
// @lc code=end

