/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// brute force O(n^3)
// bin indexed tree: O(n^2 log n)
// NOTE: if there is no need to update, don't need to use index tree at all...

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(tree, i, nums[i]);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // [i j]
                int sum = prefixSum(tree, j) - prefixSum(tree, i - 1);
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    private int prefixSum(int[] tree, int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }
    private void update(int[] tree, int index, int delta) {
        for (int i = index + 1; i < tree.length; i += i & (-i)) {
            tree[i] += delta;
        }
    }
}
// @lc code=end

