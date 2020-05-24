import java.util.Stack;

/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> queue = new Stack<>();
    

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    void stackToQueue() {
        if (this.queue.isEmpty()) {
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        stackToQueue();
        return this.queue.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        stackToQueue();
        return this.queue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.queue.isEmpty() && this.stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

