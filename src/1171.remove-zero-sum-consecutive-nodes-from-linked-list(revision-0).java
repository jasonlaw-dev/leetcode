import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1171 lang=java
 *
 * [1171] Remove Zero Sum Consecutive Nodes from Linked List
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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummyHead);
        dummyHead.next = head;
        ListNode curr = head;
        int sum = 0;
        while (curr != null) {
            sum += curr.val;
            if (map.containsKey(sum)) {
                ListNode temp = map.get(sum).next;
                while (temp != curr) {
                    sum += temp.val;
                    map.remove(sum);
                    temp = temp.next;
                }
                sum += curr.val;
                map.get(sum).next = curr.next;
            } else {
                map.put(sum, curr);
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
// @lc code=end

