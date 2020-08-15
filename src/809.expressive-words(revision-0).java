import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=809 lang=java
 *
 * [809] Expressive Words
 */

// @lc code=start

class Node {
    char c;
    int count;
    Node(char c, int count) {
        this.c = c;
        this.count = count;
    }
}

class Solution {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        List<Node> targetList = wordToNodes(S);
        for (String word : words) {
            if (word.length() > S.length()) {
                continue;
            }
            List<Node> nodeList = wordToNodes(word);
            if (nodeList.size() != targetList.size()) {
                continue;
            }
            int i;
            for (i = 0; i < nodeList.size(); i++) {
                Node t = targetList.get(i);
                Node n = nodeList.get(i);
                if (t.c != n.c || n.count > t.count || t.count < 3 && n.count != t.count) {
                    break;
                }
            }
            if (i == nodeList.size()) {
                res++;
            }
        }
        return res;
    }
    private List<Node> wordToNodes(String word) {
        List<Node> res = new ArrayList<>();
        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            Node node = new Node(c, 1);
            i++;
            while (i < word.length() && c == word.charAt(i)) {
                node.count++;
                i++;
            }
            res.add(node);
        }
        return res;
    }
}
// @lc code=end

