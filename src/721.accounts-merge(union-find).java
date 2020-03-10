import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start
class Solution {
    Map<String, String> parent = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                emailToName.put(account.get(j), account.get(0));
                union(account.get(1), account.get(j));
            }
        }
        Map<String, List<String>> resMap = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String par = find(email);
            resMap.computeIfAbsent(par, k -> new ArrayList<>()).add(email);
        }
        List<List<String>> res = new ArrayList<>();
        for (String par : resMap.keySet()) {
            List<String> emails = resMap.get(par);
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(emailToName.get(par));
            account.addAll(emails);
            res.add(account);
        }
        return res;
    }

    private String find(String a) {
        String par = parent.getOrDefault(a, a);
        if (!par.equals(a)) {
            par = find(parent.get(a));
            parent.put(a, par);
        }
        return par;
    }

    private void union(String a, String b) {
        String x = find(a);
        String y = find(b);
        if (!x.equals(y)) {
            parent.put(x, y);
        }
    }
}
// @lc code=end

