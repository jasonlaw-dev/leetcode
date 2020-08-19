#include <vector>
using namespace std;
/*
 * @lc app=leetcode id=684 lang=cpp
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
public:
    int find(vector<int>& parents, int i) {
        if (parents[i] != i) {
            parents[i] = find(parents, parents[i]);
        }
        return parents[i];
    }
    bool merge(vector<int>& parents, int i, int j) {
        int x = find(parents, i);
        int y = find(parents, j);
        if (x != y) {
            parents[x] = y;
            return true;
        } else {
            return false;
        }
    }
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        vector<int> parents(edges.size() + 1);
        for (int i = 1; i <= edges.size(); i++) {
            parents[i] = i;
        }
        for (auto& edge : edges) {
            if (!merge(parents, edge[0], edge[1])) {
                return edge;
            }
        }
        return vector<int>();
    }
};
// @lc code=end

