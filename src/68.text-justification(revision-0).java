import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 1;
        while (i < words.length) {
            int len = words[i].length();
            int spaces = 0;
            while (j < words.length && len + words[j].length() + spaces + 1 <= maxWidth) {
                len += words[j].length();
                spaces++;
                j++;
            }
            sb.append(words[i]);

            if (spaces > 0) {
                spaces = maxWidth - len;
                int spacesPerWord = spaces / (j - i - 1);
                // cutoff is i if space is distributed evenly
                // if remainder is 1, then cutoff will i + 1
                int cutoff = i + (spaces % (j - i - 1));

                if (j == words.length) {
                    spacesPerWord = 1;
                    cutoff = i;
                }

                for (int k = i + 1; k < j; k++) {
                    int spacesCurrWord = k <= cutoff ? spacesPerWord + 1 : spacesPerWord;
                    for (int q = 0; q < spacesCurrWord; q++) {
                        sb.append(' ');
                    }
                    sb.append(words[k]);
                }
            }
            while (sb.length() < maxWidth) {
                sb.append(' ');
            }
            res.add(sb.toString());
            sb = new StringBuilder();
            i = j;
            j++;
        }
        return res;
    }
}
// @lc code=end

