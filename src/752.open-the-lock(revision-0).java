import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;

        boolean[] visited = new boolean[10000];
        for (String deadend: deadends) {
            visited[toStr(deadend)] = true;
        }

        if (visited[0]) {
            return -1;
        }
        

        Queue<String> queue = new ArrayDeque<>();
        int res = 0;

        queue.offer("0000");
        visited[0] = true;

        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int n = 0; n < size; n++) {
                char[] chars = queue.poll().toCharArray();
                for (int i = 0; i < 4; i++) {
                    char c = chars[i];
                    for (int d = c - 1; d <= c + 2; d += 2) {
                        chars[i] = (char) (d == '0' - 1 ? '9' : (d == '9' + 1 ? '0' : d));
                        String next = new String(chars);
                        if (next.equals(target)) {
                            return res;
                        }
                        if (!visited[Integer.parseInt(next)]) {
                            queue.add(next);
                            visited[Integer.parseInt(next)] = true;
                        }
                    }
                    chars[i] = c;
                }  
            }
        }
        return -1;
    }
    private int toStr(String str) {
        return Integer.parseInt(str);
    }
}
// @lc code=end

