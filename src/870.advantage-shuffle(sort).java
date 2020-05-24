import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=870 lang=java
 *
 * [870] Advantage Shuffle
 * 
 * brute force O(n ^ 2), if no advantage at current index, try to swap until we have
 * sort both array, use two pointers to find the result => O(n log (n))
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        
        int[][] indexes = new int[B.length][1];
        for (int i = 0; i < A.length; i++) {
            indexes[i][0] = i;
        }
        Arrays.sort(indexes, (a, b) -> B[b[0]] - B[a[0]]);
        int i = 0;
        int j = A.length - 1;
        int[] res = new int[A.length];
        for (int[] index : indexes) {
            if (B[index[0]] < A[j]) {
                res[index[0]] = A[j--];
            } else {
                res[index[0]] = A[i++];
            }
        }
        return res;
    }
}
// @lc code=end

