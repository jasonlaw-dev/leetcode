import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=857 lang=java
 *
 * [857] Minimum Cost to Hire K Workers
 */

// @lc code=start
class Solution {
    // need to calculate unit cost by using wage / quality

    // [10, 20, 5]
    // [70, 50, 30]

    // [, 30]
    // [, 140]
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[] ratio = new double[quality.length];
        Integer[] indices = new Integer[quality.length];
        for (int i = 0; i < quality.length; i++) {
            indices[i] = i;
            ratio[i] = wage[i] * 1.0 / quality[i];
        }
        Arrays.sort(indices, (a, b) -> {
            if (ratio[a] < ratio[b]) {
                return -1;
            }
            if (ratio[a] > ratio[b]) {
                return 1;
            }
            return 0;
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> quality[b] - quality[a]);
        double res = Integer.MAX_VALUE;
        int sum = 0;
        for (int idx : indices) {

            maxHeap.add(idx);
            sum += quality[idx];
            if (maxHeap.size() > K) {
                sum -= quality[maxHeap.poll()];
            }
            if (maxHeap.size() == K) {
                res = Math.min(res, sum * ratio[idx]);
            }
        }
        return res;
    }
}
// @lc code=end

