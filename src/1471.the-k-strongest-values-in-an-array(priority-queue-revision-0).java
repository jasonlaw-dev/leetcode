import java.util.Arrays;
import java.util.PriorityQueue;

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
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int score1 = Math.abs(a - median);
            int score2 = Math.abs(b - median);
            if (score1 != score2) {
                return score2 - score1;
            }
            return b - a;
        });
        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
// @lc code=end

