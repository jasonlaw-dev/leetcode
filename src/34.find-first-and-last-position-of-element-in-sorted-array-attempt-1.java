/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

/*
 leftMatch
mid <- (start + end) / 2

1st bin search -> find match

2nd:
if (nums[mid] < target) { go right}
else go left
on

3rd:
if (nums[mid] > target) { go left}
else go right
on

*/

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int match = -1;

        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                match = mid;
                break;
            }
            if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (match != -1) {
            // 2nd bin search
            lo = 0;
            hi = match - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            result[0] = hi + 1;

            // 3rd bin search
            lo = match + 1;
            hi = nums.length - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            result[1] = lo - 1;
        }
        return result;
    }
}
// @lc code=end

