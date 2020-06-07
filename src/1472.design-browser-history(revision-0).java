import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=1472 lang=java
 *
 * [1472] Design Browser History
 */

// @lc code=start
class BrowserHistory {
    
    Deque<String> backHist = new ArrayDeque<>();
    Deque<String> forwardHist = new ArrayDeque<>();
    String curr;

    public BrowserHistory(String homepage) {
        this.curr = homepage;
    }
    
    public void visit(String url) {
        backHist.push(curr);
        curr = url;
        forwardHist.clear();
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps && !backHist.isEmpty(); i++) {
            forwardHist.push(curr);
            curr = backHist.pop();
        }
        return curr;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps && !forwardHist.isEmpty(); i++) {
            backHist.push(curr);
            curr = forwardHist.pop();
        }
        return curr;
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

