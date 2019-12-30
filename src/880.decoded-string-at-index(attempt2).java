import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=880 lang=java
 *
 * [880] Decoded String at Index
 */

// @lc code=start
class Node {
    String str;
    int repeat = 1;
    int len = 0;
    Node() {
        str = "";
    }
}
class Solution {
    public String decodeAtIndex(String S, int K) {
        List<Node> nodes = new ArrayList<>();
        Node curr = new Node();
        nodes.add(curr);
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c >= '0' && c <= '9') {
                curr.repeat *= c - '0';
                if (K <= curr.len * curr.repeat) {
                    break;
                }
            } else {
                if (i > 0 && (S.charAt(i-1) >= '0' && S.charAt(i-1) <= '9')) {
                    int len = curr.len * curr.repeat;
                    curr = new Node();
                    curr.len = len;
                    nodes.add(curr);
                }
                curr.str += c;
                curr.len++;
                if (K == curr.len) {
                    return c + "";
                }
            }
        }
        K--;
        for (int i = nodes.size() - 1; i >= 0; i--) {
            curr = nodes.get(i);
            K = K % curr.len;
            int prevNodeLength = curr.len - curr.str.length();
            if (K >= prevNodeLength) {
                return curr.str.charAt(K - prevNodeLength) + "";
            }
        }
        return null;
    }
}
// @lc code=end

