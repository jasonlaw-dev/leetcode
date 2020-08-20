#include <vector>
using namespace std;

/*
 * @lc app=leetcode id=685 lang=cpp
 *
 * [685] Redundant Connection II
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
            parents[y] = x;
            return true;
        } else {
            return false;
        }
    }
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        vector<int> parents(edges.size() + 1, 0);
        vector<int> candA;
        vector<int> candB;
        for (auto& edge : edges) {
            if (parents[edge[1]] != 0) {
                candA = {parents[edge[1]], edge[1]};
                candB = edge;
                edge[1] = 0;
            } else {
                parents[edge[1]] = edge[0];
            }
        }
        for (int i = 1; i <= edges.size(); i++) {
            parents[i] = i;
        }
        for (auto& edge : edges) {
            if (!merge(parents, edge[0], edge[1])) {
                return candA.size() == 0 ? edge : candA;
            }
        }
        return candB;
    }
};
// @lc code=end

