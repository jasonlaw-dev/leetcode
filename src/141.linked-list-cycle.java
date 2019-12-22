import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode visited = new ListNode(0);
        while (head != null) {
            if (head.next == visited) {
                return true;
            }
            ListNode next = head.next;
            head.next = visited;
            head = next;
        }
        return false;
    }
}
// @lc code=end

