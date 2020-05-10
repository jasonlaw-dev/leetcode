import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=677 lang=java
 *
 * [677] Map Sum Pairs
 */

// @lc code=start
class MapSum {

    Map<String, Integer> prefixMap = new HashMap<>();
    Map<String, Integer> keyMap = new HashMap<>();
    /** Initialize your data structure here. */
    public MapSum() {
        
    }
    
    public void insert(String key, int val) {
        int prev = keyMap.getOrDefault(key, 0);
        for (int i = 0; i <= key.length(); i++) {
            String prefix = key.substring(0, i);
            prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + val - prev);
        }
        keyMap.put(key, val);
    }
    
    public int sum(String prefix) {
        return prefixMap.getOrDefault(prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end

