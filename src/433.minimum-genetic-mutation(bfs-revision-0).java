import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=433 lang=java
 *
 * [433] Minimum Genetic Mutation
 */

// @lc code=start
class Solution {
    char[] choices = {'A', 'C', 'G', 'T'};
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String str : bank) set.add(str);
        if (!set.contains(end)) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        for (int res = 0; !queue.isEmpty(); res++) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String curr = queue.poll();
                if (curr.equals(end)) {
                    return res;
                }
                char[] arr = curr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char temp = arr[i];
                    for (char choice : choices) {
                        if (choice != temp) {
                            arr[i] = choice;
                            String next = new String(arr);
                            if (set.contains(next)) {
                                set.remove(next);
                                queue.offer(next);
                            }
                        }
                    }
                    arr[i] = temp;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

