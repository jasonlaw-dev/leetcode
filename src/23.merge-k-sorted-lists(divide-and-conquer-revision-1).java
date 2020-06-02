/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        for (int k = 1; k < lists.length; k *= 2) {
            for (int i = 0; i < lists.length; i += k * 2) {
                ListNode node1 = lists[i];
                ListNode node2 = i + k < lists.length ? lists[i + k] : null;
                ListNode dummyHead = new ListNode(0);
                ListNode curr = dummyHead;
                while (node1 != null && node2 != null) {
                    if (node1.val < node2.val) {
                        curr.next = node1;
                        node1 = node1.next;
                    } else {
                        curr.next = node2;
                        node2 = node2.next;
                    }
                    curr = curr.next;
                }
                curr.next = node1 != null ? node1 : node2;
                
                lists[i] = dummyHead.next;
            }
        }
        return lists[0];
    }
}
// @lc code=end

