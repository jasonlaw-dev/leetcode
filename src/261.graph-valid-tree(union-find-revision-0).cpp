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
    int components;
    int find(vector<int>& parents, int i) {
        if (parents[i] != i) {
            parents[i] = find(parents, parents[i]);
        }
        return parents[i];
    }

    void merge(vector<int>& parents, int i, int j) {
        int x = find(parents, i);
        int y = find(parents, j);
        if (x != y) {
            parents[x] = y;
            components--;
        }
    }

    bool validTree(int n, vector<vector<int>>& edges) {
        components = n;
        if (n == 0) {
            return true;
        }
        if (edges.size() != n - 1) {
            return false;
        }
        vector<int> parents(n);
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (auto& edge : edges) {
            merge(parents, edge[0], edge[1]);
        }
        return this->components == 1;
    }
};
// @lc code=end

