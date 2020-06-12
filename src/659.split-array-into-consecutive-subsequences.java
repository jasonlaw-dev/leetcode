import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=659 lang=java
 *
 * [659] Split Array into Consecutive Subsequences
 */

// @lc code=start
class Solution {
    int count = 0;
    HashMap<Integer, int[]> map = new HashMap<>();
    public boolean isPossible(int[] nums) {
        for (int num : nums) {
            add(num);
        }
        for (int[] curr : map.values()) {
            if (curr[0] > 0 || curr[1] > 0) {
                return false;
            }
        }
        return true;
    }
    public void add(int n) {
        int len = 0;
        if (map.containsKey(n - 1)) {
            int[] prev = map.get(n - 1);
            for (int i = 0; i < 3; i++) {
                if (prev[i] > 0) {
                    prev[i]--;
                    len = i + 1;
                    break;
                }
            }
        }
        int[] curr = map.computeIfAbsent(n, k -> new int[3]);
        curr[len >= 3 ? 2 : len]++;
    }
}
// @lc code=end

