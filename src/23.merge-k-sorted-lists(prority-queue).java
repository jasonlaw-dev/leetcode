import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 * 
 * Time: O(n log k), O(n) for traversing all nodes, O(log k) for priority queue
 * Space: O(k) (if we can modify the original lists), O(n+k) if not
 * NOTE: beware of 0 length! It can cause illegal args exception
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return head.next;
    }
}
// @lc code=end

