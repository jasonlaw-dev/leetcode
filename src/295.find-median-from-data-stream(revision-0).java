import java.util.Collections;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        int left = maxHeap.isEmpty() ? Integer.MIN_VALUE : maxHeap.peek();
        if (num > left) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        int sizeDiff = maxHeap.size() - minHeap.size();
        if (sizeDiff > 1) {
            minHeap.add(maxHeap.poll());
        } else if (sizeDiff < 0) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) { // odd
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

