import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start


class LFUCache {

    int initialCapacity;
    int capacity;
    int minFreq = 0;

    Map<Integer, LinkedHashMap<Integer, Integer>> freqMap = new HashMap<>();

    Map<Integer, Integer> keyMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.initialCapacity = capacity;
        freqMap.put(0, new LinkedHashMap<>());
    }

    int set(int key, Integer val) {
        int freq = keyMap.get(key);
        keyMap.put(key, freq + 1);
        LinkedHashMap<Integer, Integer> originalFreqMap = freqMap.get(freq);
        if (val == null) {
            val = originalFreqMap.get(key);
        }
        originalFreqMap.remove(key);
        if (originalFreqMap.isEmpty() && freq == minFreq) {
            if (freq != 0) {
                freqMap.remove(freq);
            }
            minFreq++;
        }

        freqMap.putIfAbsent(freq + 1, new LinkedHashMap<>());
        // System.out.println("putting key: "  + key + " freq: " + (freq + 1));
        freqMap.get(freq + 1).put(key, val);
        return val;
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        return set(key, null);
    }
    
    public void put(int key, int value) {
        if (initialCapacity == 0) {
            return;
        }

        if (keyMap.containsKey(key)) {
            set(key, value);
        } else {
            if (capacity == 0) {
                LinkedHashMap<Integer, Integer> firstFreqMap = freqMap.get(minFreq);
                int keyToRemove = firstFreqMap.keySet().iterator().next();
                // System.out.println("poping freq: "  + minFreq + " key: " + keyToRemove + " when checking " + key);

                firstFreqMap.remove(keyToRemove);
                if (firstFreqMap.isEmpty()) {
                    freqMap.remove(minFreq);
                }
                keyMap.remove(keyToRemove);
                capacity++;
            }
            minFreq = 1;
            keyMap.put(key, 0);
            set(key, value);
            capacity--;
        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

