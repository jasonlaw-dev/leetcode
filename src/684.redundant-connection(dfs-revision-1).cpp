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
    bool dfs(vector<vector<int>>& graph, int from, int to, int prev) {
        if (from == to) {
            return true;
        }
        for (int next : graph[from]) {
            if (next != prev) {
                if (dfs(graph, next, to, from)) {
                    return true;
                }
            }
        }
        return false;
    }
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        vector<vector<int>> graph(edges.size() + 1, vector<int>());
        for (auto& edge : edges) {
            if (dfs(graph, edge[0], edge[1], -1)) {
                return edge;
            }
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        return vector<int>();
    }
};
// @lc code=end

