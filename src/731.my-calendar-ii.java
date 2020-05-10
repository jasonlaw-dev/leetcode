import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=731 lang=java
 *
 * [731] My Calendar II
 */

// @lc code=start
class MyCalendarTwo {

    List<int[]> books = new ArrayList<>();
    public MyCalendarTwo() {
        
    }
    
    public boolean book(int start, int end) {
        MyCalendar overlapped = new MyCalendar();
        for (int[] book : books) {
            if (Math.max(book[0], start) < Math.min(book[1], end)) {
                if (!overlapped.book(Math.max(book[0], start), Math.min(book[1], end))) {
                    return false;
                }
            }
        }
        books.add(new int[] {start, end});
        return true;
    }

    static class MyCalendar {

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
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

