import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=947 lang=java
 *
 * [947] Most Stones Removed with Same Row or Column
 */

// @lc code=start
class Solution {
    int components;
    public int removeStones(int[][] stones) {
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        int n = stones.length;
        int[] parents = new int[n];
        components = n;
        for (int i = 0; i < stones.length; i++) {
            parents[i] = i;
            if (rows.containsKey(stones[i][0])) {
                union(parents, i, rows.get(stones[i][0]));
            } else {
                rows.put(stones[i][0], i);
            }
            if (cols.containsKey(stones[i][1])) {
                union(parents, i, cols.get(stones[i][1]));
            } else {
                cols.put(stones[i][1], i);
            }
        }
        return n - components;
    }
    private void union(int[] parents, int i, int j) {
        int x = find(parents, i);
        int y = find(parents, j);
        if (x != y) {
            components--;
            parents[y] = x;
        }
    }
    private int find(int[] parents, int i) {
        if (parents[i] != i) {
            parents[i] = find(parents, parents[i]);
        }
        return parents[i];
    }
}
// @lc code=end

