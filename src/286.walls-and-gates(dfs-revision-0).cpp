#include <vector>
#include <array>
using namespace std;
/*
 * @lc app=leetcode id=286 lang=cpp
 *
 * [286] Walls and Gates
 */

// @lc code=start
int dirs[4][2]{{0,1},{0,-1},{1,0},{-1,0}};
// array<array<int, 2>, 4> dirs{{{0,1},{0,-1},{1,0},{-1,0}}};
class Solution {
public:
    int dfs(vector<vector<int>>& rooms, int i, int j) {
        for (auto &dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < rooms.size() && y >= 0 && y < rooms[0].size() && rooms[x][y] > rooms[i][j] + 1) {
                rooms[x][y] = rooms[i][j] + 1;
                dfs(rooms, x, y);
            }
        }
        return rooms[i][j];
    }
    void wallsAndGates(vector<vector<int>>& rooms) {
        if (rooms.size() == 0) return;
        for (int i = 0; i < rooms.size(); i++) {
            for (int j = 0; j < rooms[0].size(); j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j);
                }
            }
        }
    }
};
// @lc code=end

