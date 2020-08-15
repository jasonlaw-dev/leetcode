#include <vector>
#include <queue>
#include <array>
using namespace std;
/*
 * @lc app=leetcode id=286 lang=cpp
 *
 * [286] Walls and Gates
 */

// @lc code=start
int dirs[][2]{{0,1},{0,-1},{1,0},{-1,0}};
// array<array<int, 2>, 4> dirs{{{0,1},{0,-1},{1,0},{-1,0}}};
class Solution {
public:
    void wallsAndGates(vector<vector<int>>& rooms) {
        if (rooms.size() == 0) return;
        int m = rooms.size();
        int n = rooms[0].size();
        queue<int> q;
        for (int i = 0; i < rooms.size(); i++) {
            for (int j = 0; j < rooms[0].size(); j++) {
                if (rooms[i][j] == 0) {
                    q.push(i * n + j);
                }
            }
        }
        while (q.size()) {
            int curr = q.front();
            q.pop();
            int i = curr / n;
            int j = curr % n;
            for (auto &dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && rooms[i][j] + 1 < rooms[x][y]) {
                    rooms[x][y] = rooms[i][j] + 1;
                    q.push(x * n + y);
                }
            }
        }
    }
};
// @lc code=end

