/*
 * @lc app=leetcode id=839 lang=java
 *
 * [839] Similar String Groups
 */

// @lc code=start
class Solution {
    public int numSimilarGroups(String[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != null) {
                String str = A[i];
                A[i] = null;
                dfs(A, str);
                count++;
            }
        }
        return count;
    }
    private void dfs(String[] A, String str) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] != null) {
                String next = A[i];
                if (isSimilar(str, next)) {
                    A[i] = null;
                    dfs(A, next);
                }
            }
        }
    }
    private boolean isSimilar(String a, String b) {
        int n = a.length();
        int diff = 0;
        for (int i = 0; i < n && diff <= 2; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 0 || diff == 2;
    }
}
// @lc code=end

