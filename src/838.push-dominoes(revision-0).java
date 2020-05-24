/*
 * @lc app=leetcode id=838 lang=java
 *
 * [838] Push Dominoes
 */

// @lc code=start
class Solution {
    public String pushDominoes(String dominoes) {
        char prev = 'L';
        char[] A = dominoes.toCharArray();
        int i = -1;
        for (int j = 0; j < A.length; j++) {
            char curr = A[j];
            if (curr == '.') continue;
            
            if (curr == 'L') {
                if (prev == 'L') {
                    fill(A, 'L', i + 1, j - 1);
                } else {
                    fill(A, 'R', i + 1, i + (j - i - 1) / 2);
                    fill(A, 'L', j - (j - i - 1) / 2 , j - 1);
                }
            } else {
                if (prev == 'R') {
                    fill(A, 'R', i + 1, j - 1);
                }
            }
            prev = curr;
            i = j;
        }
        if (prev == 'R') {
            fill(A, 'R', i + 1, A.length - 1);
        }
        return new String(A);
    }
    public void fill(char[] A, char c, int i, int j) {
        for (; i <= j; i++) {
            A[i] = c;
        }
    }
}
// @lc code=end

