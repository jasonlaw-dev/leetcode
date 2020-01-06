import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    /** Initialize your data structure here. */
    public RandomizedSet() {
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        map.remove(val);
        if (index == list.size() - 1) {
            list.remove(index);
        } else {
            int lastVal = list.get(list.size() - 1);
            map.put(lastVal, index);
            list.set(index, lastVal);
            list.remove(list.size() - 1);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

