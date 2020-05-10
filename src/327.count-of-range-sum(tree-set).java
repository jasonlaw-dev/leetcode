import java.util.TreeSet;

/*
 * @lc app=leetcode id=327 lang=java
 *
 * [327] Count of Range Sum
 */
/*
[0, -2, 3, 2]

*/
// @lc code=start
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long cumSum = 0;
        TreeSet<long[]> set = new TreeSet<>((a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[0], b[0]);
        });
        set.add(new long[]{0,-1});
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            cumSum += nums[i];
            res += set.subSet(new long[]{cumSum - upper, -2}, new long[]{cumSum - lower, nums.length}).size();
            set.add(new long[] {cumSum, i});
        }
        return res;
    }
}
// @lc code=end

