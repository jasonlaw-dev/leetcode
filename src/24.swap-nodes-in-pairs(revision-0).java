/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 * Time: O(n)
 * Space: O(1)
 * 
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
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode tail = newHead;

        while (tail.next != null) {
            tail.next = swap(tail.next);
            if (tail.next.next != null) {
                tail = tail.next.next;
            } else {
                break;
            }
        }
        return newHead.next;
    }

    public ListNode swap(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode nodeToReturn = node.next;
        ListNode temp = nodeToReturn.next;
        nodeToReturn.next = node;
        node.next = temp;
        return nodeToReturn;
    }
}
// @lc code=end

