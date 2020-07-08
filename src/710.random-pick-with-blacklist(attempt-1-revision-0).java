import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=710 lang=java
 *
 * [710] Random Pick with Blacklist
 */

// @lc code=start
class Solution {

    int N;
    Set<Integer> blacklist = new HashSet<>();
    List<Integer> whitelist = null;
    public Solution(int N, int[] blacklist) {
        if (blacklist.length > N / 2) {
            Arrays.sort(blacklist);
            whitelist = new ArrayList<>();
            for (int i = 0, j = 0; i < N; i++) {
                if (j != blacklist.length && blacklist[j] == i) {
                    j++;
                } else {
                    whitelist.add(i);
                }
            }
        } else {
            for (int black : blacklist) {
                this.blacklist.add(black);
            }
        }

        this.N = N;
    }
    
    public int pick() {
        if (whitelist != null) {
            return whitelist.get((int) (Math.random() * whitelist.size()));
        }
        int pick;
        do {
            pick = (int) (Math.random() * N);
        } while (blacklist.contains(pick));
        return pick;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
// @lc code=end

