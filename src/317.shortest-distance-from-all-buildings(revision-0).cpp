#include <vector>
#include <unordered_set>
#include <queue>

using namespace std;
/*
 * @lc app=leetcode id=317 lang=cpp
 *
 * [317] Shortest Distance from All Buildings
 * 
 * Idea: starting from all buildings, use BFS to traverse each route
 * for each direction, we mark as visied, increment count at that position, and add the number of steps it required to reach there
 * 
 * NOTE: we can't terminate early in the DFS, cuz the fastest way to reach building count is not necessarily the lowest cost
 * 
 * Space: O(m * n)
 * Time: O(m^2  * n^2)
 */

// @lc code=start
class Solution {
private:
    int dirs[4][2]{{0,1},{0,-1},{1,0},{-1,0}};
public:
    int shortestDistance(vector<vector<int>>& grid) {
        int m = grid.size();
        if (m == 0) return -1;
        int n = grid[0].size();
        
        int buildingId = -1;
        
        vector<vector<int>> result(m, vector<int>(n, 0));
        queue<int> q;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildingId++;

                    q.push(i * n + j);
                    int dist = 0;
                    while (q.size()) {
                        int size = q.size();
                        for (int k = 0; k < size; k++) {
                            int ij = q.front();
                            q.pop();
                            int i = ij / n;
                            int j = ij % n;
                            
                            for (auto& dir : dirs) {
                                int x = i + dir[0];
                                int y = j + dir[1];
                                if (x < 0 || x >= m || y < 0 || y >= n) {
                                    continue;
                                }
                                if (grid[x][y] == -buildingId) { // we use non positive numbers to indicate valid ones
                                    grid[x][y]--;
                                    result[x][y] += dist + 1;
                                    q.push(x * n + y);
                                }
                            }
                        }
                        dist++;
                    }
                }
            }
        }
        int minDist = INT_MAX;
        int buildingCount = buildingId + 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -buildingCount) {
                    minDist = min(minDist, result[i][j]);
                }
            }
        }
        
        return minDist == INT_MAX ? -1 : minDist;
    }
};
// @lc code=end

