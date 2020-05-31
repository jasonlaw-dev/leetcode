import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 */

// @lc code=start
class Node {
    String exp;
    long val;
    long toMul;
    Node(String exp, long val, long toMul) {
        this.exp = exp;
        this.val = val;
        this.toMul = toMul;
    }
}
class Solution {

    int len;
    public List<String> addOperators(String num, int target) {
        len = num.length();
        if (len == 0) {
            return new ArrayList<>();
        }
        List<Node> cands = new ArrayList<>();
        // for (int i = 0; i < len; i++) {
        //     int idx = index(i, i);
        //     if (!map.containsKey(idx)) {
        //         map.put(idx, new HashMap<>());
        //     }
        //     char c = num.charAt(i);
        //     map.get(idx).put(c + "", new Node(c - '0', true));
        // }
        for (int i = 0; i < len; i++) {
            List<Node> next = new ArrayList<>();
            
            for (int j = i + 1; j < i + k; j++) { // j == start of the right part
                Map<String, Node> left = map.get(index(i, j - 1));
                Map<String, Node> right = map.get(index(j, i + k - 1));
                for (String leftKey : left.keySet()) {
                    for (String rightKey : right.keySet()) {
                        Node leftNode = left.get(leftKey);
                        Node rightNode = right.get(rightKey);
                        if (leftNode.mulOnly && rightNode.mulOnly) {
                            long val = leftNode.val * rightNode.val;
                            if (val >= Integer.MIN_VALUE && val <= Integer.MAX_VALUE) {
                                currMap.put(leftKey + "*" + rightKey, new Node(val, true));
                            }
                        }
                        currMap.put(leftKey + "+" + rightKey, new Node(leftNode.val + rightNode.val, false));
                        currMap.put(leftKey + "-" + rightKey, new Node(leftNode.val - rightNode.val, false));
                    }
                }
            }
            String subNum = num.substring(0, i + 1);
            if (i == 0 || subNum.charAt(0) != '0') {
                long val = Long.parseLong(subNum);
                next.add(new Node(subNum, val, val));
            }
            cands = next;
        }
        List<String> res = new ArrayList<>();
        Map<String, Node> resMap = map.get(index(0, len - 1));
        for (String key : resMap.keySet()) {
            Node node = resMap.get(key);
            if (node.val == target) {
                res.add(key);
            }
        }
        return res;
    }
    private int index(int i, int j) {
        return i * len + j;
    }
}
// @lc code=end

