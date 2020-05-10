import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 * 
 * < < < > 
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length < 2) return asteroids;
        int curr = 1;
        int prev = 0;
        while (curr < asteroids.length) {
            if (prev == -1) {
                asteroids[0] = asteroids[curr];
                curr++;
                prev++;
            } else {
                if (asteroids[prev] > 0 && asteroids[curr] < 0) {
                    if (asteroids[prev] == -asteroids[curr]) {
                        prev--;
                        curr++;
                    } else if (asteroids[prev] > -asteroids[curr]) {
                        curr++;
                    } else {
                        prev--;
                    }
                } else {
                    prev++;
                    asteroids[prev] = asteroids[curr];
                    curr++;
                }
            }
        }
        return Arrays.copyOf(asteroids, prev + 1);

    }
}
// @lc code=end

