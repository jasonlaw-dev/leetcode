import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num + "");
        }
        list.sort((a, b) -> {
            int len = Math.max(a.length(), b.length());
            char prev = '0';
            for (int i = 0; i < len; i++) {
                char c = i >= a.length() ? prev : a.charAt(i);
                char d = i >= b.length() ? prev : b.charAt(i);

                if (c > d) {
                    return -1;
                } else if (d > c) {
                    return 1;
                } else {
                    prev = (char) Math.max(c + 0, prev + 0);
                }
            }
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 && list.get(i).equals("0")) {
                return "0";
            }
            sb.append(list.get(i));
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
// @lc code=end

