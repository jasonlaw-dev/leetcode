import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        Set<String> valid = new HashSet<>();
        for (String str : bank) valid.add(str);
        if (!valid.contains(end)) {
            return -1;
        }
        return dfs(start, end, new HashMap<>(), valid);
    }
    private int dfs(String start, String end, Map<String, Integer> memo, Set<String> valid) {
        if (start.equals(end)) {
            return 0;
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        int res = Integer.MAX_VALUE;
        memo.put(start, -1);

        char[] arr = start.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char original = arr[i];
            for (char choice : choices) {
                if (choice != original) {
                    arr[i] = choice;
                    String next = new String(arr);
                    if (valid.contains(next)) {
                        int temp = dfs(next, end, memo, valid);
                        if (temp != -1) {
                            res = Math.min(res, 1 + temp);
                        }
                    }
                }
            }
            arr[i] = original;
        }
        if (res == Integer.MAX_VALUE) {
            res = -1;
        }
        memo.put(start, res);
        return res;
    }
}
// @lc code=end

