import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=846 lang=java
 *
 * 
 * pq is 
 * [846] Hand of Straights
 */

// @lc code=start
class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        if (W == 1) return true;
        int N = hand.length / W;
        // (last, len)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Arrays.sort(hand);
        for (int num : hand) {
            if (pq.isEmpty() || pq.peek()[0] == num) {
                if (N == 0) return false;
                N--;
                pq.add(new int[] {num, 1});
            } else if (pq.peek()[0] + 1 == num) {
                int[] curr = pq.poll();
                curr[0]++;
                curr[1]++;
                if (curr[1] != W) {
                    pq.add(curr);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

