import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=895 lang=java
 *
 * [895] Maximum Frequency Stack
 */

// @lc code=start
class Node {
    int key;
    List<Integer> indexes = new ArrayList<>();
    int count;
    Node(int key, int index) {
        this.key = key;
        this.indexes.add(index);
        count = 1;
    }
}
class FreqStack {

    HashMap<Integer, Node> nodeMap = new HashMap<>();
    TreeSet<Node> treeSet = new TreeSet<>((a, b) -> {
        if (a.count != b.count) {
            return b.count - a.count;
        }
        return b.indexes.get(b.indexes.size() - 1) - a.indexes.get(a.indexes.size() - 1);
    });
    int index = 0;

    public FreqStack() {
        
    }

    public void push(int x) {
        Node node = nodeMap.get(x);
        if (node == null) {
            node = new Node(x, index++);
            nodeMap.put(x, node);
        } else {
            treeSet.remove(node);
            node.count++;
            node.indexes.add(index++);
        }
        treeSet.add(node);
    }
    
    public int pop() {
        Node node = treeSet.pollFirst();
        node.indexes.remove(node.indexes.size() - 1);
        node.count--;
        if (node.count > 0) {
            treeSet.add(node);
        }
        return node.key;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
// @lc code=end

