#include <vector>
#include <unordered_set>
#include <queue>
using namespace std;
/*
 * @lc app=leetcode id=773 lang=cpp
 *
 * [773] Sliding Puzzle
 */

// @lc code=start
class Solution {
public:
    int dirs[4][2]{{0,1},{0,-1},{1,0},{-1,0}};
    int boardToKey(vector<vector<int>>& board) {
        int k = 1;
        int key = 0;
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                key += board[i][j] * k;
                k *= 6;
            }
        }
        return key;
    }
    void keyToBoard(vector<vector<int>>& board, int key) {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                board[i][j] = key % 6;
                key /= 6;
            }
        }
    }
    void printBoard(vector<vector<int>>& board) {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                cout << board[i][j] << " ";
            }
        }
        cout << endl;
    }
    int slidingPuzzle(vector<vector<int>>& board) {
        unordered_set<int> visited;
        queue<int> q;
        int initial = boardToKey(board);
        q.push(initial);
        visited.insert(initial);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 2) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = i * 3 + j + 1;
                }
            }
        }
        int end = boardToKey(board);
        int move = 0;
        while (q.size()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.front();
                if (curr == end) {
                    return move;
                }
                q.pop();
                keyToBoard(board, curr);
                int i;
                int j;
                for (i = 0; i < 2; i++) {
                    for (j = 0; j < 3; j++) {
                        if (board[i][j] == 0) {
                            break;
                        }
                    }
                    if (j != 3) {
                        break;
                    }
                }
                for (auto& dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < 2 && y >= 0 && y < 3) {
                        board[i][j] = board[x][y];
                        board[x][y] = 0;
                    
                        int next = boardToKey(board);
                        if (visited.find(next) == visited.end()) {
                            visited.insert(next);
                            q.push(next);
                        }

                        board[x][y] = board[i][j];
                        board[i][j] = 0;
                    }
                }
            }
            move++;
        }
        return -1;
    }
};
// @lc code=end

