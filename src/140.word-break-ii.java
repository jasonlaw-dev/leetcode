import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int maxLength = 0;
        for (String word: wordDict){
            words.add(word);
            maxLength = Math.max(word.length(), maxLength);
        }
        List<List<List<Integer>>> dp = new ArrayList<>();
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            List<List<Integer>> currList = new ArrayList<>();
            if (words.contains(s.substring(0, i + 1))) {
                currList.add(Arrays.asList(i));
            }
            for (int j = Math.max(1, i - maxLength); j <= i; j++) {
                if (words.contains(s.substring(j, i + 1))) {
                    for (List<Integer> list : dp.get(j - 1)) {
                        List<Integer> copy = new ArrayList<>(list);
                        copy.add(i);
                        currList.add(copy);
                    }
                }
            }
            dp.add(currList);
        }
        for (List<Integer> list : dp.get(s.length() - 1)) {
            StringBuilder sb = new StringBuilder();
            int prev = 0;
            for (int num : list) {
                if (prev != 0) {
                    sb.append(' ');
                }
                sb.append(s.substring(prev, num + 1));
                prev = num + 1;
            }
            res.add(sb.toString());
        }
        return res;
    }
}
// @lc code=end

