import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=381 lang=java
 *
 * [381] Insert Delete GetRandom O(1) - Duplicates allowed
 * 
 * Insert O(1): need map and array
 * Delete O(1): -> if no duplicate, simply take the last element 
 * and move it to the deleted
 * 
 * Map<Integer, int[] / Set / stack>
 * 
 * Map:
 * 1 -> {1}
 * 2 -> {0}
 * Array:
 * [2,1]
 *
 */



// @lc code=start
class RandomizedCollection {

    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }
        Set<Integer> set = map.get(val);
        set.add(list.size());
        list.add(val);
        return set.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> set = map.get(val);
        if (set != null && !set.isEmpty()) {
            int pos = set.iterator().next();
            if (pos == list.size() - 1 || val == list.get(list.size() - 1)) {
                set.remove(list.size() - 1);
                list.remove(list.size() - 1);
            } else {
                int replace = list.get(list.size() - 1);
                Set<Integer> replaceSet = map.get(replace);
                replaceSet.remove(list.size() - 1);
                replaceSet.add(pos);

                list.set(pos, replace);
                list.remove(list.size() - 1);
                set.remove(pos);
            }
            return true;
        }
        return false;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

