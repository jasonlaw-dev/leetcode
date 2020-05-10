/*
 * @lc app=leetcode id=769 lang=java
 *
 * [769] Max Chunks To Make Sorted
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int min = 10;
        int max = 0;
        for (int i = 0, j = 0; j < arr.length; j++) {
            if (i == j) {
                min = arr[j];
                max = arr[j];
            }
            min = Math.min(min, arr[j]);
            max = Math.max(max, arr[j]);
            if (min == i && max == j) {
                res++;
                i = j + 1;
            }
        }
        return res;
    }
}
// @lc code=end

