import java.util.Arrays;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=327 lang=java
 *
 * [327] Count of Range Sum
 */
/*
[0, -2, 3, 2]

[-2, 0] [2, 3]

*/
// @lc code=start
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return mergeSort(sums, 0, sums.length - 1, lower, upper);
    }
    private int mergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (start >= end) return 0;
        int mid = (start + end) / 2;
        int res = mergeSort(sums, start, mid, lower, upper) + mergeSort(sums, mid + 1, end, lower, upper);

        long[] left = new long[mid - start + 1];
        long[] right = new long[end - mid];
        for (int i = start; i <= mid; i++) left[i - start] = sums[i];
        for (int i = mid + 1; i <= end; i++) right[i - mid - 1] = sums[i];

        int low = 0; int high = 0;
        int idx = start;
        int i = 0;
        int j = 0;
        for (; i < left.length; i++) {
            while (low < right.length && right[low] - left[i] < lower) low++;
            while (high < right.length && right[high] - left[i] <= upper) high++;
            res += high - low;

            while (j < right.length && right[j] < left[i]) sums[idx++] = right[j++];
            sums[idx++] = left[i];
        }
        while (j < right.length) {
            sums[idx++] = right[j++];
        }
        return res;
    }
}
// @lc code=end

