/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        int length = 0;

        ListNode left = dummyHead;
        while (left.next != null) {
            length++;
            left = left.next;
        }

        if (length > 0) {
            k = k % length;
            if (k > 0) {
                System.out.println(k);
                left = dummyHead;
                ListNode right = dummyHead;
                for (int i = 0; i < k; i++) {
                    right = right.next;
                }
                while (right.next != null) {
                    right = right.next;
                    left = left.next;
                }
                right.next = dummyHead.next;
                dummyHead.next = left.next;
                left.next = null;
            }
        }
        return dummyHead.next;
    }
}
// @lc code=end

