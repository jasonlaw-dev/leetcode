/*
 * @lc app=leetcode id=1186 lang=java
 *
 * [1186] Maximum Subarray Sum with One Deletion
 * 
 * O(n*n) O(n^2)
 * try to achivee O(n log n) or O(n)
 * max = 17
 * [5, 8, -8, -15, 2, 7, -1, 9, -1]
 * -1 => 14
 * most negative number = -15
 */

// @lc code=start
class Solution {
    public int maximumSum(int[] arr) {
        int res = arr[0];
        int noDelete = arr[0];
        int oneDelete = 0;
        for (int i = 1; i < arr.length; i++) {
            oneDelete = Math.max(oneDelete + arr[i], noDelete);
            noDelete = Math.max(noDelete + arr[i], arr[i]);
            res = Math.max(res, Math.max(oneDelete, noDelete));
        }
        return res;
    }
}
// @lc code=end

