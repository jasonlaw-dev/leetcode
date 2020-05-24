import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 * 
 * graph approach
 * directed graph thats from room 0
 * 0 -> (1,3)
 */

// @lc code=start
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            for (int j : rooms.get(i)) {
                if (!seen.contains(j)) {
                    seen.add(j);
                    stack.add(j);
                    if (rooms.size() == seen.size()) return true;
                }
            }
        }
        return rooms.size() == seen.size();
    }
}
// @lc code=end

