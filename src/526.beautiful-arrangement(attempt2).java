import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=526 lang=java
 *
 * [526] Beautiful Arrangement
 */

// @lc code=start
class Solution {
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int i = 1; i <= N; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 1; j <= N; j++) {
                if (j % i == 0 || i % j == 0) {
                    curr.add(j);
                }
            }
            list.add(curr);

        }
        return bt(1, N, visited, list);
    }

    private int bt(int i, int N, boolean[] visited, List<List<Integer>> list) {
        if (i == N + 1) {
            return 1;
        }
        int sum = 0;
        for (int j : list.get(i)) {
            if (!visited[j]) {
                visited[j] = true;
                sum += bt(i + 1, N, visited, list);
                visited[j] = false;
            }
        }
        return sum;
    }

}
// @lc code=end

