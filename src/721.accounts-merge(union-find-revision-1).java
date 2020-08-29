import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start
class Solution {
    
    private String find(Map<String, String> parents, String i) {
        if (!parents.get(i).equals(i)) {
            parents.put(i, find(parents, parents.get(i)));
        }
        return parents.get(i);
    }
    private void union(Map<String, String> parents, String i, String j) {
        if (!parents.containsKey(i)) {
            parents.put(i, i);
        }
        if (!parents.containsKey(j)) {
            parents.put(j, j);
        }
        String x = find(parents, i);
        String y = find(parents, j);
        if (!x.equals(y)) {
            parents.put(x, y);
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parents = new HashMap<>();
        Map<String, String> nameMap = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                nameMap.put(account.get(i), account.get(0));
                union(parents, account.get(1), account.get(i));
            }
        }
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> idxMap = new HashMap<>();
        List<String> allEmails = new ArrayList<>(parents.keySet());
        Collections.sort(allEmails);
        for (String email : allEmails) {
            String parent = find(parents, email);
            if (!idxMap.containsKey(parent)) {
                idxMap.put(parent, res.size());
                res.add(new ArrayList<>());
                res.get(res.size() - 1).add(nameMap.get(parent));
            }
            res.get(idxMap.get(parent)).add(email);
        }
        return res;
    }
}
// @lc code=end

