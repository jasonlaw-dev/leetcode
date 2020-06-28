import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=1496 lang=java
 *
 * [1496] Path Crossing
 */

// @lc code=start
class Solution {
    public boolean isPathCrossing(String path) {
        Set<Integer> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add(index(x,y));
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x--;
            } else if (c == 'W') {
                x++;
            }
            if (set.contains(index(x,y))) {
                return true;
            }
            set.add(index(x,y));
        }
        return false;
    }
    private int index(int x, int y) {
        return (x + 10000) * 20002 + (y + 10000);
    }
}
// @lc code=end

