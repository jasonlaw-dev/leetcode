/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 * 
 * Time: O(n)
 * Space: O(1)
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;

        ListNode curr1 = l1;
        ListNode curr2 = l2;

        while (true) {
            if (curr1 == null && curr2 == null) {
                break;
            }
            if (curr1 == null || curr2 == null) {
                ListNode nonNull = curr1 != null ? curr1 : curr2;
                if (tail == null) {
                    head = nonNull;
                    break;
                }
                tail.next = nonNull;
                break;
            }
            ListNode smaller;
            if (curr1.val <= curr2.val) {
                smaller = curr1;
                curr1 = curr1.next;
            } else {
                smaller = curr2;
                curr2 = curr2.next;
            }
            if (tail == null) {
                head = smaller;
                tail = smaller;
            } else {
                tail.next = smaller;
                tail = smaller;
            }
        }

        return head;
    }
}
// @lc code=end

