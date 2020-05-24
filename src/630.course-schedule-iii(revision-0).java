import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=630 lang=java
 *
 * [630] Course Schedule III
 * 
 * Try to think of non-intersecting intervals -> then would figure out this solution
 */


// [1, 200], [198, 200], [1, 201]


// @lc code=start
class Solution {
    public int scheduleCourse(int[][] courses) {
        int sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(courses, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        for (int[] course : courses) {
            if (sum + course[0] <= course[1]) {
                sum += course[0];
                heap.add(course[0]);
            } else if (sum > 0 && heap.peek() > course[0]) {
                sum += course[0] - heap.poll();
                heap.add(course[0]);
            }
        }
        return heap.size();
    }
}
// @lc code=end

