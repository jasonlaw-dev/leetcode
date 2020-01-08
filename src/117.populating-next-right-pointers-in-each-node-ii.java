/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node curr = root;
        while (curr != null) {
            Node first = null;
            Node last = null;
            while (curr != null) {
                for (int i = 0; i < 2; i ++) {
                    Node child = i == 0 ? curr.left : curr.right;
                    if (child != null) {
                        if (first != null) {
                            last.next = child;
                        } else {
                            first = child;
                        }
                        last = child;
                    }
                }
                curr = curr.next;
            }
            curr = first;
        }
        return root;
    }
}
// @lc code=end

