import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        List<Set<Integer>> sets = new ArrayList<>();
        sets.add(new HashSet<>());
        sets.get(0).add(0);
        int maxJump = 0;
        for (int i = 1; i < stones.length; i++) {
            Set<Integer> currSet = new HashSet<>();

            if (stones[i] - stones[i - 1] > maxJump + 1) {
                return false;
            }

            for (int j = 0; j < i; j++) {
                int k = stones[i] - stones[j];
                if (k > maxJump + 1 || sets.get(j).size() == 0) {
                    continue;
                }
                for (int delta = -1; delta <= 1; delta++) {
                    if (sets.get(j).contains(k + delta)) {
                        currSet.add(k);
                        maxJump = Math.max(k, maxJump);
                        break;
                    }
                }
            }
            sets.add(currSet);
        }
        return sets.get(stones.length - 1).size() != 0;
    }
}
// @lc code=end

