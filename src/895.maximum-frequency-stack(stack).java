import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=895 lang=java
 *
 * [895] Maximum Frequency Stack
 */

// @lc code=start
class FreqStack {

    Map<Integer, Integer> freqs = new HashMap<>();
    Map<Integer, Stack<Integer>> groups = new HashMap<>();
    int maxFreq = 0;

    public FreqStack() {
        
    }

    public void push(int x) {
        int freq = freqs.getOrDefault(x, 0) + 1;
        freqs.put(x, freq);
        if (freq > maxFreq) {
            maxFreq++;
            groups.put(freq, new Stack<>());
        }
        groups.get(freq).add(x);
    }
    
    public int pop() {
        int val = groups.get(maxFreq).pop();
        freqs.put(val, maxFreq - 1);
        if (groups.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
// @lc code=end

