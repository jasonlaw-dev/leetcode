import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.add(count[i]);
            }
        }
        int res = 0;
        while (!pq.isEmpty()) {
            List<Integer> next = new ArrayList<>();
            int i = 0;
            for (; !pq.isEmpty() && i <= n; i++) {
                int task = pq.poll();
                if (task > 1) {
                    next.add(task - 1);
                }
            }
            pq.addAll(next);
            if (!pq.isEmpty()) {
                res += n + 1;
            } else {
                res += i;
            }
        }
        return res;
    }
}
// @lc code=end

