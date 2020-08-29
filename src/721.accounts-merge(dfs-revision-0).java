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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<Integer>> emailToIndex = new HashMap<>();
        boolean[] visited = new boolean[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                emailToIndex.computeIfAbsent(account.get(j), k -> new HashSet<>()).add(i);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (!visited[i]) {
                List<String> account = new ArrayList<>();
                account.add(accounts.get(i).get(0));
                Set<String> emails = new HashSet<>();
                dfs(accounts, visited, emailToIndex, i, emails);
                List<String> emailsList = new ArrayList<>(emails);
                Collections.sort(emailsList);
                account.addAll(emailsList);
                res.add(account);
            }
        }
        return res;
    }
    private void dfs(List<List<String>> accounts, boolean[] visited, Map<String, Set<Integer>> emailToIndex, int i, Set<String> emails) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        List<String> account = accounts.get(i);
        for (int j = 1; j < account.size(); j++) {
            String email = account.get(j);
            emails.add(email);
            for (int k : emailToIndex.get(email)) {
                dfs(accounts, visited, emailToIndex, k, emails);
            }
        }
    }
}
// @lc code=end

