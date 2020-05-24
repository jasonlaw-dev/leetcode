import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            Node newNode = new Node(curr.val);
            newNode.random = curr.random;
            curr.next = newNode;
            newNode.next = next;

            curr = next;
        }
        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            if (copy.random != null) {
                copy.random = curr.random.next;
            }
            curr = copy.next;
        }

        Node dummyHead = new Node(0);
        Node currCopy = dummyHead;

        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            currCopy.next = copy;

            curr.next = copy.next;
            curr = copy.next;
            currCopy = copy;
        }

        return dummyHead.next;
    }
}
// @lc code=end

