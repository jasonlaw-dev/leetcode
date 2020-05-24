/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */



// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = 0;
        
        while (k <= j) {
            if (nums[k] == 0) {
                if (i != k) {
                    swap(nums, i, k);
                }
                i++;
                k++;
            } else if (nums[k] == 2) {
                if (j != k) {
                    swap(nums, j, k);
                }
                j--;
            } else {
                k++;
            }
        }
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

