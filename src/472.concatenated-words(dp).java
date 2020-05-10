import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 */

// @lc code=start
class Solution {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (!word.equals("") && canForm(word, set)) {
                res.add(word);
            }
            set.add(word);
        }
        return res;
    }
    private boolean canForm(String word, Set<String> set) {
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (!dp[j]) continue;
                if (set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
// @lc code=end

