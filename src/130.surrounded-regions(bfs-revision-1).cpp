#include <vector>
#include <queue>
using namespace std;
/*
 * @lc app=leetcode id=130 lang=cpp
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
public:
    int dirs[4][2]{{0,1},{0,-1},{1,0},{-1,0}};
    void solve(vector<vector<char>>& board) {
        if (board.size() == 0 || board[0].size() == 0) {
            return;
        }
        int m = board.size();
        int n = board[0].size();
        queue<vector<int>> q;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '_';
                q.push({i, 0});
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = '_';
                q.push({i, n - 1});
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '_';
                q.push({0, j});
            }
            if (board[m-1][j] == 'O') {
                board[m-1][j] = '_';
                q.push({m-1, j});
            }
        }
        while (q.size()) {
            auto ij = q.front();
            q.pop();
            int i = ij[0];
            int j = ij[1];
            for (auto& dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                    board[x][y] = '_';
                    q.push({x, y});
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '_') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
};
// @lc code=end

