/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

/*
Use binary search to achieve O(log (m+n))

NOTE: Use binary search to partition the smaller array, calculate partition in the larger array
make sure that all elements in left partition <= right.

This is really hard and probably will not be finished in 45 mins.
Try to make up a way to do part of the steps.

*/

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            int[] nonEmpty = nums1.length != 0 ? nums1 : nums2;
            int mid = nonEmpty.length / 2;
            return nonEmpty.length % 2 == 1 ? nonEmpty[mid] : (nonEmpty[mid - 1] + nonEmpty[mid]) * 1.0 / 2;
        }
        if (nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int low = 0;
        int high = nums1.length;
        
        int l1, r1, l2, r2;
        while (true) {
            int mid1 = low + (high - low) / 2;
            int mid2 = (nums1.length + nums2.length) / 2 - mid1;

            l1 = mid1 <= 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            r1 = mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1];

            l2 = mid2 <= 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            r2 = mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                break;
            }
            if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (Math.max(l1, l2) + Math.min(r1,r2)) / 2.0;
        }
        return Math.min(r1, r2);
    }
}
// @lc code=end

