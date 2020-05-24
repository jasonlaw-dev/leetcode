import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 */

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class Node {
    List<NestedInteger> list;
    int index = 0;
    Node(List<NestedInteger> nestedList) {
        this.list = nestedList;
    }
}

class NestedIterator implements Iterator<Integer> {

    Deque<Node> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack.push(new Node(nestedList));
    }

    void prepareNext() {
        while (!stack.isEmpty()) {
            Node curr = stack.peek();
            int index = curr.index;
            List<NestedInteger> list = curr.list;
            if (index >= list.size()) {
                stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek().index++;
                }
            } else if (!list.get(index).isInteger()) {
                stack.push(new Node(list.get(index).getList()));
            } else {
                break;
            }
        }
    }

    @Override
    public Integer next() {
        Node curr = stack.peek();
        int val = curr.list.get(curr.index).getInteger();
        curr.index++;
        return val;
    }

    @Override
    public boolean hasNext() {
        prepareNext();
        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

