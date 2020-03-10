import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        bt(s, 0, res, new ArrayList<>(), 4);
        return res;
    }
    public void bt(String s, int start, List<String> res, List<String> curr, int groups) {
        int remainingLength = s.length() - start;
        if (remainingLength < 0 || remainingLength > 3 * groups || remainingLength < groups) {
            return;
        }
        if (remainingLength == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(curr.get(i));
                if (i != 3) {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
            return;
        }
        int maxLen = Math.min(remainingLength, 3);
        for (int len = 1; len <= maxLen; len++) {
            String part = s.substring(start, start + len);
            if (part.length() > 1 && part.charAt(0) == '0') continue;
            if (part.length() < 3 || part.compareTo("255") <= 0) {
                curr.add(part);
                bt(s, start + len, res, curr, groups - 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
// @lc code=end

