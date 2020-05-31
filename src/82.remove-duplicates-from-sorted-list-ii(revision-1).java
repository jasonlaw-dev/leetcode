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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        ListNode prev = dummyHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next == null || curr.next.val != curr.val) {
                prev.next = curr;
                prev = curr;
            } else {
                while (curr.next != null && curr.next.val == curr.val) {
                    curr = curr.next;
                }
            }
            curr = curr.next;
        }
        prev.next = null;
        return dummyHead.next;
    }
}
// @lc code=end

