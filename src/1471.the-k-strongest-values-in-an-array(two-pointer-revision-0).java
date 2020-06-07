import java.util.Arrays;

/*
 * @lc app=leetcode id=1471 lang=java
 *
 * [1471] The k Strongest Values in an Array
 */

// @lc code=start
class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);

        int median = arr[(arr.length - 1) / 2];
        int left = 0;
        int right = arr.length - 1;
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (Math.abs(arr[left] - median) > Math.abs(arr[right] - median)) {
                res[i] = arr[left++];
            } else {
                res[i] = arr[right--];
            }
        }
        return res;
    }
}
// @lc code=end

