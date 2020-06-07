import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=1472 lang=java
 *
 * [1472] Design Browser History
 */

// @lc code=start
class BrowserHistory {
    
    List<String> hist = new ArrayList<>();
    int idx = 0;
    int size = 1;

    public BrowserHistory(String homepage) {
        hist.add(homepage);
    }
    
    public void visit(String url) {
        idx++;
        if (idx >= hist.size()) {
            hist.add(url);
        } else {
            hist.set(idx, url);
        }
        size = idx + 1;
    }
    
    public String back(int steps) {
        idx = Math.max(0, idx - steps);
        return hist.get(idx);
    }
    
    public String forward(int steps) {
        idx = Math.min(size - 1, idx + steps);
        return hist.get(idx);
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
// @lc code=end

