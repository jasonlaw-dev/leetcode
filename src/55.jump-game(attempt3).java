/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
       int lastIndex = nums.length - 1;
       for (int i = lastIndex - 1; i >= 0; i--) {
           if (i + nums[i] >= lastIndex) {
               lastIndex = i;
           }
       }
       return lastIndex == 0;
    }
}
// @lc code=end

