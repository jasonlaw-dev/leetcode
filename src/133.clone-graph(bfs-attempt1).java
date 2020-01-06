import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            Node copy = new Node(curr.val, new ArrayList<>());
            map.put(curr, copy);
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        for (Node curr : map.keySet()) {
            Node copy = map.get(curr);
            for (Node neighbor : curr.neighbors) {
                copy.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
// @lc code=end

