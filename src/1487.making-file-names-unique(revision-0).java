import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=1487 lang=java
 *
 * [1487] Making File Names Unique
 */

// @lc code=start
class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Set<Integer>> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) {
                map.put(names[i], new HashSet<>());
            }
            if (names[i].endsWith(")")) {
                int lastIndex = names[i].lastIndexOf('(');
                String prefix = names[i].substring(0, lastIndex);
                int val = Integer.parseInt(names[i].substring(lastIndex + 1, names[i].length() - 1));
                if (val != 0) {
                    map.putIfAbsent(prefix, new HashSet<>());
                    map.get(prefix).add(val);    
                }    
            }
            String cand = null;
            int j = 0;
            Set<Integer> set = map.get(names[i]);
            for (; set.contains(j); j++) {
            }
            set.add(j);
            if (j == 0) {
                cand = names[i];
            } else {
                cand = names[i] + "(" + j +")";
                map.putIfAbsent(cand, new HashSet<>());
                map.get(cand).add(0);
            }
            res[i] = cand;
            
        }
        return res;
    }
}
// @lc code=end

