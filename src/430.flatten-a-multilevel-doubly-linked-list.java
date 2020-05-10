/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        flat(head);
        return head;
    }
    public Node flat(Node head) {
        while (head != null) {
            if (head.child != null) {
                Node next = head.next;

                head.next = head.child;
                head.next.prev = head;
                head.child = null;

                Node childTail = flat(head.next);
                if (next != null) {
                    next.prev = childTail;
                }
                childTail.next = next;

                head = childTail;
            }

            if (head.next == null) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
// @lc code=end

