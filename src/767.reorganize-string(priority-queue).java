import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            count[c - 'a']++;
        }

        // [alphabet, count]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        for (int c = 0; c < 26; c++) {
            pq.add(new int[]{ c, count[c] });
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = pq.poll();
        if (prev[1] > (S.length() + 1) / 2) {
            return "";
        }
        sb.append((char) (prev[0] + 'a'));
        prev[1]--;
        for (int i = 1; i < S.length(); i++) {
            int[] curr = pq.poll();
            sb.append((char) (curr[0] + 'a'));
            curr[1]--;

            pq.offer(prev);
            prev = curr;
        }
        return sb.toString();
    }
}
// @lc code=end

