import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=421 lang=java
 *
 * [421] Maximum XOR of Two Numbers in an Array
 */

// @lc code=start
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int bits = 30; bits >= 0; bits--) {
            Set<Integer> prefixes = new HashSet<>();
            mask |= (1 << bits);
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            int toTry = max | (1 << bits);
            for (int num : nums) {
                if (prefixes.contains((num & mask) ^ toTry)) {
                    max = toTry;
                    break;
                }
            }
        }
        return max;
    }
}
// @lc code=end

