import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=990 lang=java
 *
 * [990] Satisfiability of Equality Equations
 */

// @lc code=start
class Solution {
    int[] parents = new int[26];
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            parents[i] = i;
        }
        List<int[]> notEquals = new ArrayList<>();
        for (String eqn : equations) {
            int i = eqn.charAt(0) - 'a';
            int j = eqn.charAt(3) - 'a';
            if (eqn.charAt(1) == '=') {
                union(i, j);
            } else {
                notEquals.add(new int[]{i, j});
            }
        }
        for (int[] notEqual : notEquals) {
            int i = notEqual[0];
            int j = notEqual[1];
            if (find(i) == find(j)) {
                return false;
            }
        }
        return true;
    }
    private void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            parents[x] = y;
        }
    }

    private int find(int i) {
        if (parents[i] != i) {
            parents[i] = find(parents[i]);
        }
        return parents[i];
    }
}
// @lc code=end

