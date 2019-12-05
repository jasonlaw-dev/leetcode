/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int furthest = 0;
        int steps = 0;
        int i = 0;
        while (i < nums.length - 1) {
            int nextFurthest = furthest;
            for (int j = furthest; j >= i; j--) {
                nextFurthest = Math.max(nextFurthest, j + nums[j]);
                if (nextFurthest >= nums.length - 1) {
                    return steps + 1;
                }
            }
            steps++;
            i = furthest + 1;
            furthest = nextFurthest;
        }
        return steps;
    }
}
// @lc code=end

