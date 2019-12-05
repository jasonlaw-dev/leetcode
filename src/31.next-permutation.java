/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * Time: O(n)
 * Space: O(1)
 * NOTE: careless mistakes again!!
 * How to solve this question? start writing cases, brute force the algorithm and find out the pattern.
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i != -1) { // we have found a match where we need to swap
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }
        // right now nums[i + 1] to end is sorted in reverse.
        i += 1;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
// @lc code=end

