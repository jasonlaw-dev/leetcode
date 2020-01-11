import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] indexes = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            indexes[S.charAt(i) - 'a'] = i;
        }
        int len = 0;
        for (int i = 0; i < S.length(); i++) {
            int lenToAdd = indexes[S.charAt(i) - 'a'] + 1 - len;
            if (i >= len) {
                res.add(lenToAdd);
                len += lenToAdd;
            } else {
                if (lenToAdd > 0) {
                    res.set(res.size() - 1, res.get(res.size() - 1) + lenToAdd);
                    len += lenToAdd;
                }
            }
        }
        
        return res;
    }
}
// @lc code=end

