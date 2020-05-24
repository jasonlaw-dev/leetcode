/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// Time: O(max(m, n))
// Space: O(max(m, n))
// Note: be careful in using variable (I used l1 and l2 which led to incorrect results)

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        

        int carry = 0;
        ListNode result = null;
        ListNode last = null;

        while (true) {
            if (carry == 0) {
                if (curr1 == null && curr2 == null) {
                    return result;
                }
                if (curr1 == null) {
                    last.next = curr2;
                    return result;
                }
                if (curr2 == null) {
                    last.next = curr1;
                    return result;
                }
            }

            int sum = (curr1 != null ? curr1.val : 0) + (curr2 != null ? curr2.val : 0) + carry;
            carry = sum / 10; // rounded down
            ListNode node = new ListNode(sum % 10);
            if (result == null) {
                result = node;
            } else {
                last.next = node;
            }
            last = node;
            
            if (curr1 != null) {
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                curr2 = curr2.next;
            }
        }
    }
}
// @lc code=end

