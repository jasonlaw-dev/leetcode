import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int[] checkResult = check(s);
        int wrongTotal = checkResult[0] + checkResult[1];
        List<String> results = new ArrayList<>();
        Map<String, int[]> map = new HashMap<>();
        map.put(s, checkResult);
        for (; wrongTotal > 0; wrongTotal--) {
            Map<String, int[]> nextMap = new HashMap<>();
            for (String nextStr : map.keySet()) {
                int[] val = map.get(nextStr);
                for (int i = 0; i < nextStr.length(); i++) {
                    char c = nextStr.charAt(i);
                    if (c == '(' && val[0] > 0 || c == ')' && val[1] > 0) {
                        String removed = nextStr.substring(0, i) + nextStr.substring(i+1, nextStr.length());
                        if (!nextMap.containsKey(removed)) {
                            int[] nextVal = new int[]{val[0] - (c == '(' ? 1 : 0), val[1] - (c == ')' ? 1 : 0)};
                            nextMap.put(removed, nextVal);
                        }
                    }
                }
            }
            map = nextMap;
        }
        for (String str : map.keySet()) {
            checkResult = check(str);
            if (checkResult[0] == 0 && checkResult[1] == 0) {
                results.add(str);
            }
        }
        return results;
    }

    int[] check(String s) {
        int wrongOpen = 0;
        int wrongClose = 0;
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                } else {
                    wrongClose++;
                }
            }
        }
        wrongOpen = open;
        return new int[]{wrongOpen, wrongClose};
    }
}
// @lc code=end

