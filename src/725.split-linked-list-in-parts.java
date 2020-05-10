/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
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
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode curr = root;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        
        int m = len / k;
        curr = root;
        ListNode prev = null;

        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++) {
            int n = len % (k - i) == 0 ? m : m + 1;
            len -= n;

            res[i] = curr;
            for (int j = 0; j < n && curr != null; j++) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) {
                prev.next = null;
            }
        }
        return res;
    }
}
// @lc code=end

