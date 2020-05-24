import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start

class ListNode {
    int val;
    int key;
    ListNode left = null;
    ListNode right = null;
    ListNode(int val) {
        this.val = val;
    }
}

class LRUCache {

    int capacity;
    int size = 0;
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode start;
    ListNode end;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        start = new ListNode(0);
        end = new ListNode(0);
        start.right = end;
        end.left = start;
    }
    
    void removeFromList(ListNode node) {
        ListNode left = node.left;
        ListNode right = node.right;
        left.right = right;
        right.left = left;
    }

    void addToList(ListNode node) {
        end.left.right = node;
        node.left = end.left;
        node.right = end;
        end.left = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            removeFromList(node);
            addToList(node);
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            removeFromList(node);
            node.val = value;
            addToList(node);
        } else {
            ListNode node = new ListNode(value);
            node.key = key;
            if (size == capacity) {
                map.remove(start.right.key);
                removeFromList(start.right);  
                size--;
            }
            map.put(key, node);
            size++;
            addToList(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

