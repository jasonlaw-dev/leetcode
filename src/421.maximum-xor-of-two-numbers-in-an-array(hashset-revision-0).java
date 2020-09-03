import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=421 lang=java
 *
 * [421] Maximum XOR of Two Numbers in an Array
 */

// @lc code=start

class TrieNode {
    TrieNode[] next = new TrieNode[2];
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            int tmp = max | (1 << i);
            for (int prefix : set) {
                int anotherNum = tmp ^ prefix;
                if (set.contains(anotherNum)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
// @lc code=end

