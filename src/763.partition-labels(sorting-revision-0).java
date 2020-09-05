import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */
// sorting is O(26) = O(1)
// good when string is long.

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[][] indexes = new int[26][2];
        for (int i = 0; i < 26; i++) {
            indexes[i][0] = -1;
        }
        for (int i = 0; i < S.length(); i++) {
            int c = S.charAt(i) - 'a';
            if (indexes[c][0] == -1) {
                indexes[c][0] = i;
            }
            indexes[c][1] = i;
        }
        Arrays.sort(indexes, (a, b) -> a[0] - b[0]);
        List<Integer> res = new ArrayList<>();
        int len = 1;
        res.add(1);
        for (int i = 0; i < 26; i++) {
            if (indexes[i][0] != -1) {
                if (indexes[i][0] < len) {
                    int lenToAdd = Math.max(0, indexes[i][1] - len + 1);
                    res.set(res.size() - 1, res.get(res.size() - 1) + lenToAdd);
                    len += lenToAdd;
                } else {
                    int lenToAdd = indexes[i][1] - indexes[i][0] + 1;
                    res.add(lenToAdd);
                    len += lenToAdd;
                }
            }
        }
        return res;
    }
}
// @lc code=end

