import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=710 lang=java
 *
 * [710] Random Pick with Blacklist
 */

// @lc code=start
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int M;
    public Solution(int N, int[] blacklist) {
        for (int black : blacklist) {
            map.put(black, -1);
        }
        M = N - blacklist.length;
        for (int black : blacklist) {
            if (black < M) {
                while (map.containsKey(N - 1)) {
                    N--;
                }
                N--;
                map.put(black, N);
            }
        }
    }
    
    public int pick() {
        int p = (int) (Math.random() * M);
        if (map.containsKey(p)) {
            return map.get(p);
        }
        return p;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
// @lc code=end

