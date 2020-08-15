import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=362 lang=java
 *
 * [362] Design Hit Counter
 */

// @lc code=start
class HitCounter {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int count = 0;
    /** Initialize your data structure here. */
    public HitCounter() {
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        count++;
        map.put(timestamp, count);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        Map.Entry<Integer, Integer> entry = map.floorEntry(timestamp - 300);
        return count - (entry != null ? entry.getValue() : 0);
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
// @lc code=end

