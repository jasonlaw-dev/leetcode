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
        return dfs(node, map);  
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node copy = new Node(node.val, new ArrayList<>());
        map.put(node, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }
        return copy;
    }
}
// @lc code=end

