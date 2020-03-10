import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=336 lang=java
 *
 * [336] Palindrome Pairs
 */

// @lc code=start
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            if (len > 0) {
                for (int k = 0; k < len - 1; k++) {
                    if (isPalindrome(word, 0, k)) {
                        Integer j = map.get(word.substring(k + 1, len));
                        if (j != null) {
                            res.add(Arrays.asList(j, i));
                        }
                    }
                }
                for (int k = 1; k < len; k++) {
                    if (isPalindrome(word, k, len - 1)) {
                        Integer j = map.get(word.substring(0, k));
                        if (j != null) {
                            res.add(Arrays.asList(i, j));
                        }
                    }
                }
                if (isPalindrome(word, 0, len - 1)) {
                    if (map.containsKey("")) {
                        int j = map.get("");
                        res.add(Arrays.asList(i, j));
                        res.add(Arrays.asList(j, i));
                    }
                } else if (map.containsKey(word)) {
                    res.add(Arrays.asList(i, map.get(word)));
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// @lc code=end

