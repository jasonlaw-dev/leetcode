#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <stack>
using namespace std;
/*
 * @lc app=leetcode id=261 lang=cpp
 *
 * [261] Graph Valid Tree
 */

// @lc code=start
class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        if (n == 0) {
            return true;
        }
        if (edges.size() != n - 1) {
            return false;
        }
        unordered_map<int, vector<int>> map;
        for (auto &pair : edges) {
            if (map.find(pair[0]) == map.end()) {
                map.insert({pair[0], vector<int>()});
            }
            if (map.find(pair[1]) == map.end()) {
                map.insert({pair[1], vector<int>()});
            }
            map[pair[0]].push_back(pair[1]);
            map[pair[1]].push_back(pair[0]);
        }
        unordered_set<int> seen{{0}};
        stack<int> st;
        st.push(0);
        while (st.size()) {
            int curr = st.top(); st.pop();
            if (map.find(curr) == map.end()) {
                continue;
            }
            for (int next : map[curr]) {
                if (seen.find(next) == seen.end()) {
                    seen.insert(next);
                    st.push(next);
                }
            }
        }
        return seen.size() == n;
    }
};
// @lc code=end

