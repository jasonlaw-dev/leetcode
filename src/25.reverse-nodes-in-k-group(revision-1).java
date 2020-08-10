/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prevGroupTail = dummyHead;
        while (true) {
            ListNode curr = prevGroupTail;
            for (int i = 0; i < k && curr != null; i++) {
                curr = curr.next;
            }
            if (curr == null) {
                break; // this has less than k nodes
            }
            ListNode currGroupTail = prevGroupTail.next;
            prevGroupTail.next = reverse(prevGroupTail.next, curr);
            prevGroupTail = currGroupTail;
        }
        return dummyHead.next;
    }
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode curr = head;
        head = tail.next;
        while (head != tail) {
            ListNode next = curr.next;
            curr.next = head;
            head = curr;
            curr = next;
        }
        return head;
    }
}
// @lc code=end

