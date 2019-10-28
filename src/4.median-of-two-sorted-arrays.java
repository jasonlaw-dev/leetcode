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
            int medianIndex = (nonEmpty.length) / 2;
            if (nonEmpty.length % 2 == 0) {
                return (nonEmpty[medianIndex] + nonEmpty[medianIndex - 1]) / 2.0;
            }
            return nonEmpty[medianIndex] * 1.0;
        }

        int[] smallArray, largeArray;
        if (nums1.length <= nums2.length) {
            smallArray = nums1;
            largeArray = nums2;
        } else {
            smallArray = nums2;
            largeArray = nums1;
        }
        int partitionIndexS = (smallArray.length) / 2;
        int partitionSLeft = 0;
        int partitionSRight = smallArray.length;
        // left side: 0 ... partitionIndexS - 1
        // right side: partitionIndexS ... length - 1
        int partitionIndexL = (nums1.length + nums2.length) / 2 - partitionIndexS;

        int s1, s2, l1, l2;
        while (true) {
            s1 = partitionIndexS <= 0 ? Integer.MIN_VALUE : smallArray[partitionIndexS - 1];
            s2 = partitionIndexS >= smallArray.length ? Integer.MAX_VALUE : smallArray[partitionIndexS];
            l1 = partitionIndexL <= 0 ? Integer.MIN_VALUE : largeArray[partitionIndexL - 1];
            l2 = partitionIndexL >= largeArray.length ? Integer.MAX_VALUE : largeArray[partitionIndexL];

            if (s1 <= l2 && l1 <= s2) { // main point of the solution, compare both partitions to ensure all elements on the left <= right
                break;
            }
            if (s1 > l2) {
                // x0, x1, x2, x3, x4, x5
                partitionSRight = partitionIndexS;
                partitionIndexS = (partitionSLeft + partitionIndexS) / 2;
            } else if (l1 > s2) {
                partitionSLeft = partitionIndexS + 1;
                partitionIndexS = (partitionIndexS + partitionSRight + 1) / 2;
            }
            partitionIndexL = (nums1.length + nums2.length) / 2 - partitionIndexS;
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (Math.max(s1, l1) + Math.min(s2, l2))/2.0;
        }
        return Math.min(s2, l2);
        
        // 3, 4, small => 1, large => 2
    }
}
// @lc code=end

