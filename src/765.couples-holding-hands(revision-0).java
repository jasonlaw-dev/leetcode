import java.util.Arrays;

/*
 * @lc app=leetcode id=765 lang=java
 *
 * [765] Couples Holding Hands
 */

// [0,1], [0,2], [1,3], [2,3]

// @lc code=start
class Solution {
    int count; // count of connected components
    public int minSwapsCouples(int[] row) {
        int N = row.length - 1;
        count = N;
        int[] parent = new int[N];
        Arrays.fill(parent, -1);
        for (int i = 0; i < row.length; i += 2) {
            union(parent, row[i] / 2, row[i + 1] / 2);
        }
        return N - count;
    }

    private void union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);
        if (x != y) {
            count--;
            parent[x] = y;
        }
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }

}
// @lc code=end

