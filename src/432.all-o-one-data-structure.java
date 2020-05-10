import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=432 lang=java
 *
 * [432] All O`one Data Structure
 */

// @lc code=start

class LinkedSetNode {
    Set<String> set = new HashSet<>();
    LinkedSetNode prev = null;
    LinkedSetNode next = null;
    int val;
    LinkedSetNode(int val) {
        this.val = val;
    }
}

class AllOne {
    
    Map<String, Integer> map = new HashMap<>();

    Map<Integer, LinkedSetNode> setMap = new HashMap<>();    
    LinkedSetNode head = new LinkedSetNode(0);
    LinkedSetNode tail = new LinkedSetNode(Integer.MAX_VALUE);

    /** Initialize your data structure here. */
    public AllOne() {
        setMap.put(0, head);
        setMap.put(Integer.MAX_VALUE, tail);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int val = map.getOrDefault(key, 0);
        map.put(key, val + 1);
        LinkedSetNode prevNode = setMap.get(val);
        prevNode.set.remove(key);

        if (prevNode.next.val == val + 1) {
            prevNode.next.set.add(key);
        } else {
            LinkedSetNode nextNode = new LinkedSetNode(val + 1);
            nextNode.set.add(key);
            nextNode.next = prevNode.next;
            nextNode.prev = prevNode;
            prevNode.next = nextNode;
            nextNode.next.prev = nextNode;
            setMap.put(val + 1, nextNode);
        }
        if (val > 0 && prevNode.set.size() == 0) {
            setMap.remove(val);
            prevNode.prev.next = prevNode.next;
            prevNode.next.prev = prevNode.prev;
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        int val = map.get(key);
        if (val > 1) {
            map.put(key, val - 1);
        } else {
            map.remove(key);
        }

        LinkedSetNode prevNode = setMap.get(val);
        prevNode.set.remove(key);

        if (prevNode.prev.val == val - 1) {
            if (val > 1) {
                prevNode.prev.set.add(key);
            }
        } else {
            LinkedSetNode nextNode = new LinkedSetNode(val - 1);
            nextNode.set.add(key);
            nextNode.next = prevNode;
            nextNode.prev = prevNode.prev;
            prevNode.prev = nextNode;
            nextNode.prev.next = nextNode;
            setMap.put(val - 1, nextNode);
        }
        if (prevNode.set.size() == 0) {
            setMap.remove(val);
            prevNode.prev.next = prevNode.next;
            prevNode.next.prev = prevNode.prev;
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.set.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.set.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
// @lc code=end

