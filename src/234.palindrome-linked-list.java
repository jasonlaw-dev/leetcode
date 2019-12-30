/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                break;
            } else {
                fast = fast.next.next;
            }
        }
        // if length is even, slow would be at start of 2nd half 
        // if odd, slow would be at mid
        // 1 2 3
        ListNode rightHead = slow;
        if (fast == null) {  // odd
            rightHead = slow.next;
        }
        // reverse ...
        ListNode tail = rightHead;
        while (tail.next != null) {
            ListNode next = tail.next;
            tail.next = next.next;
            next.next = rightHead;
            rightHead = next;
        }
        while (rightHead != null) { // use Right head!!
            if (head.val != rightHead.val) {
                return false;
            }
            head = head.next;
            rightHead = rightHead.next;
        }
        return true;
    }
}
// @lc code=end

