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
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A']++;
        }
        int result = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> tempList = new ArrayList<>();
        for (int count : counts) {
            if (count > 0) {
                heap.add(count);
            }
        }
        while (!heap.isEmpty()) {
            for (int i = 0; i < n + 1; i++) {
                if (heap.isEmpty() && tempList.isEmpty()) {
                    break;
                }
                if (!heap.isEmpty()) {
                    int count = heap.poll();
                    if (count > 1) {
                        tempList.add(count - 1);
                    }
                }
                result++;     
            }
            heap.addAll(tempList);
            tempList.clear();
        }
        return result;
    }
}
// @lc code=end

