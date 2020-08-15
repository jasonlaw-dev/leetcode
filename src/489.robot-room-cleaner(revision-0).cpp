#include <unordered_map>
#include <unordered_set>
#include <string>
using namespace std;
/*
 * @lc app=leetcode id=489 lang=cpp
 *
 * [489] Robot Room Cleaner
 */
class Robot {
  public:
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    bool move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();
    void turnRight();

    // Clean the current cell.
    void clean();
};
// @lc code=start
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * class Robot {
 *   public:
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     bool move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     void turnLeft();
 *     void turnRight();
 *
 *     // Clean the current cell.
 *     void clean();
 * };
 */



class Solution {
private:
    int moves[4][2]{{0,-1},{1,0},{0,1},{-1,0}};
    unordered_set<string> visited;
    bool isVisited(int i, int j) {
        return visited.find(to_string(i) + "_" + to_string(j)) != visited.end();
    }
    void markVisited(int i, int j) {
        visited.insert(to_string(i) + "_" + to_string(j));
    }

public:
    void clean(Robot& robot, int i, int j, int dir) {
        robot.clean();
        markVisited(i, j);
        for (int k = 0; k < 4; k++) {
            auto move = moves[(dir + k) % 4];
            int x = i + move[0];
            int y = j + move[1];
            if (!isVisited(x, y) && robot.move()) {
                clean(robot, x, y, (dir + k) % 4);
            }
            robot.turnRight();
        }
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    void cleanRoom(Robot& robot) {
        clean(robot, 0, 0, 0);
    }
};
// @lc code=end

