import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=502 lang=java
 *
 * [502] IPO
 */

// @lc code=start
class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        List<Integer> sortedCapital = new ArrayList<>();
        int n = Profits.length;
        for (int i = 0; i < n; i++) {
            sortedCapital.add(i);
        }
        Collections.sort(sortedCapital, (a, b) -> Capital[a] - Capital[b]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Profits[b] - Profits[a]);
        int i = 0;
        while (k > 0) {
            while (i < n && Capital[sortedCapital.get(i)] <= W) {
                pq.add(sortedCapital.get(i));
                i++;
            }
            if (pq.isEmpty()) {
                break;
            }
            // System.out.println(pq.peek() + " " + pq.size());
            W += Profits[pq.poll()];
            
            k--;
        }
        return W;
    }
}
// @lc code=end

