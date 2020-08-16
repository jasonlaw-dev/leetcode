#include <vector>
#include <array>
using namespace std;
/*
 * @lc app=leetcode id=305 lang=cpp
 *
 * [305] Number of Islands II
 */

// @lc code=start
class Solution {
public:
    int dirs[4][2]{{0,1},{1,0},{0,-1},{-1,0}};
    int islands = 0;
    int find(vector<int>& parents, int i) {
        if (parents[i] != i) {
            parents[i] = find(parents, parents[i]);
        }
        return parents[i];
    }
    void merge(vector<int>& parents, vector<int>& rank, int i, int j) {
        int x = find(parents, i);
        int y = find(parents, j);
        if (x != y) {
            islands--;
            if (rank[x] < rank[y]) {
                parents[x] = y;
            } else if (rank[x] > rank[y]) {
                parents[y] = x;
            } else {
                parents[x] = y;
                rank[y]++;
            }
        }
    }
    vector<int> numIslands2(int m, int n, vector<vector<int>>& positions) {
        vector<int> res;
        vector<vector<bool>> mat(m, vector<bool>(n, false));
        vector<int> parents(m * n, 0);
        vector<int> rank(m * n, 0);
        for (auto pos : positions) {
            int i = pos[0];
            int j = pos[1];
            if (mat[i][j] != true) {
                mat[i][j] = true;
                parents[i * n + j] = i * n + j;
                islands++;
                for (auto dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == true) {
                        merge(parents, rank, x * n + y, i * n + j);
                    }
                }
            }
            res.push_back(islands);
        }
        return res;
    }
};
// @lc code=end

