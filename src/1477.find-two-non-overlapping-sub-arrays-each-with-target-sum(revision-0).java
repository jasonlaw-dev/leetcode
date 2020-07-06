import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode id=1477 lang=java
 *
 * [1477] Find Two Non-overlapping Sub-arrays Each With Target Sum
 */

// @lc code=start
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] cand = null;
        int minLength = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0, j = 0; j < arr.length; j++) {
            sum += arr[j];
            while (sum > target) {
                sum -= arr[i++];
            }
            if (sum == target) {
                while (!queue.isEmpty() && queue.peek()[0] < i) {
                    cand = queue.poll();
                }
                int len = (j - i + 1);
                if (cand != null) {
                    res = Math.min(res, cand[1] + len);
                }
                if (len < minLength) {
                    minLength = len;
                    queue.offer(new int[]{j, len});
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
// @lc code=end

