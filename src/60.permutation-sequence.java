import java.util.TreeSet;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        k--;
        int[] perms = new int[n];
        boolean[] visited = new boolean[n];
        perms[0] = 1;
        for (int i = 1; i < n; i++) {
            perms[i] = perms[i - 1] * (i + 1);
        }
        
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            int indexRequired = i == n - 1 ? 0 : k / perms[n - i - 2];
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    if (indexRequired == 0) {
                        result[i] = (char)((j + 1) + '0');
                        visited[j] = true;
                        break;
                    }
                    indexRequired--;
                }
            }
            if (i == n - 1) {
                break;
            }
            k = k % perms[n - i - 2];
        }
        return new String(result);
    }
}
// @lc code=end

