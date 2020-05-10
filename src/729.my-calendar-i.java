import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 */

// @lc code=start
class MyCalendar {

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> prev = map.floorEntry(start);
        Map.Entry<Integer, Integer> next = map.ceilingEntry(start);
        if (prev != null && prev.getValue() > start) {
            return false;
        }
        if (next != null && next.getKey() < end) {
            return false;
        }
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

