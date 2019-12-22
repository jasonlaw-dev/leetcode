import java.util.Stack;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class ListNode {
    
}

class MinStack {

    Stack<Integer> values = new Stack<>();
    Stack<Integer> mins = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        values.push(x);
        if (mins.isEmpty()) {
            mins.push(x);
        } else {
            mins.push(Math.min(mins.peek(), x));
        }
    }
    
    public void pop() {
        values.pop();
        mins.pop();
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

