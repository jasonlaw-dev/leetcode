/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] counts = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char c : tasks) {
            counts[c - 'A']++;
            if (counts[c - 'A'] > max) {
                max = counts[c - 'A'];
                maxCount = 1;
            } else if (counts[c - 'A'] == max) {
                maxCount++;
            }
        }
        int emptySlots = (n + 1 - maxCount) * (max - 1);
        int availableTasks = tasks.length - maxCount * max;
        int idles = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idles;
    }
}
// @lc code=end

