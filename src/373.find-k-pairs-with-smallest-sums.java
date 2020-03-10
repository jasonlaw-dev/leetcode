import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */

// @lc code=start
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int[]{i, 0});
        }
        for (; k > 0 && !pq.isEmpty(); k--) {
            int[] curr = pq.poll();
            res.add(Arrays.asList(nums1[curr[0]], nums2[curr[1]]));
            if (curr[1] != nums2.length - 1) {
                pq.add(new int[]{curr[0], curr[1] + 1});
            }
        }
        return res;
    }
}
// @lc code=end

