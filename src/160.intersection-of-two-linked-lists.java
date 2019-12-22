/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
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
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curr = headA;
        int lengthA = 0;
        int lengthB = 0;
        while (curr != null) {
            lengthA++;
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            lengthB++;
            curr = curr.next;
        }
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }
        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }
        for (int i = 0 ; i < lengthA; i++) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
// @lc code=end

