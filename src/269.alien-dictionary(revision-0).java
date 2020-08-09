import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=269 lang=java
 *
 * [269] Alien Dictionary
 */

// @lc code=start
class Solution {
    public String alienOrder(String[] words) {
        int[] inEdges = new int[26];
        Arrays.fill(inEdges, -1);
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new HashSet<>());
        }
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                inEdges[word.charAt(i) - 'a'] = 0;
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i + 1];
            int n = Math.min(a.length(), b.length());
            int j;
            for (j = 0; j < n; j++) {
                int x = a.charAt(j) - 'a';
                int y = b.charAt(j) - 'a';
                if (x != y) {
                    if (!graph.get(x).contains(y)) {
                        graph.get(x).add(y);
                        inEdges[y]++;
                    }
                    break;
                }
            }
            if (j == n && a.length() > b.length()) {
                return "";
            }
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (inEdges[i] >= 0) {
                count++;
                if (inEdges[i] == 0) {
                    queue.add(i);
                }
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            sb.append((char)(curr + 'a'));
            for (int next : graph.get(curr)) {
                if (--inEdges[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return sb.length() == count ? sb.toString() : "";
    }
}
// @lc code=end

