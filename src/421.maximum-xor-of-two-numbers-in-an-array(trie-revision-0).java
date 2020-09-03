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
        if (nums.length < 2) {
            return 0;
        }
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode curr = root;
            for (int i = 30; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (curr.next[bit] == null) {
                    curr.next[bit] = new TrieNode();
                }
                curr = curr.next[bit];
            }
        }
        int max = 0;
        for (int num: nums) {
            TrieNode curr = root;
            int sum = 0;
            for (int i = 30; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (curr.next[bit ^ 1] != null) {
                    sum += (1 << i);
                    curr = curr.next[bit^1];
                } else {
                    curr = curr.next[bit];
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
// @lc code=end

