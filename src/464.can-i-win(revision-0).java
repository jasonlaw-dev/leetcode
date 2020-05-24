import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=464 lang=java
 *
 * [464] Can I Win
 */

// @lc code=start
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean[] visited = new boolean[maxChoosableInteger + 1];
        if ((1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal) {
            return false;
        }
        return desiredTotal <= 0 || forceWin(new HashMap<>(), visited, desiredTotal);
    }
    public boolean forceWin(Map<Integer, Boolean> map, boolean[] visited, int total) {
        if (total <= 0) {
            return false;
        }
        int key = toKey(visited);
        if (!map.containsKey(key)) {
            for (int i = visited.length - 1; i > 0; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (!forceWin(map, visited, total - i)) {
                        map.put(key, true);
                        visited[i] = false;
                        return true;
                    }
                    visited[i] = false;
                }
                map.put(key, false);
            }
        }
        return map.get(key);
    }

    public int toKey(boolean[] visited) {
        int i = 0;
        for (boolean b : visited) {
            i <<= 1;
            if (b) {
                i |= 1;
            }
        }
        return i;
    }
}
// @lc code=end

