import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=386 lang=java
 *
 * [386] Lexicographical Numbers
 * 
 * goal: define an iterative loop 
 */

// @lc code=start
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        lex(0, n, res);
        return res;
    }
    public void lex(int prefix, int n, List<Integer> res) {
        for (int i = 0; i <= 9; i++) {
            if (prefix == 0 && i == 0) continue;

            int next = prefix * 10 + i;
            if (next > n) return;
            res.add(next);
            lex(next, n, res);
        }
    }
}
// @lc code=end

