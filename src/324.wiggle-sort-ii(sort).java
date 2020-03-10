import java.util.Arrays;

/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int idx = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (idx >= nums.length) {
                idx = 0;
            }
            nums[idx] = copy[i];
            idx+=2;
        }
    }

}
// @lc code=end

